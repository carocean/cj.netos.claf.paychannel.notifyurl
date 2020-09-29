package cj.netos.claf.paychannel.notifyurl.webview;

import cj.netos.claf.paychannel.notifyurl.IChannelAccountService;
import cj.netos.claf.paychannel.notifyurl.IChannelBillService;
import cj.netos.claf.paychannel.notifyurl.IPayChannelService;
import cj.netos.claf.paychannel.notifyurl.model.ChannelAccount;
import cj.netos.claf.paychannel.notifyurl.model.ChannelBill;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.studio.gateway.socket.io.XwwwFormUrlencodedContentReciever;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.rabbitmq.client.AMQP;

import java.util.HashMap;
import java.util.Map;

@CjService(name = "/alipay/receive_notify.html")
public class AlipayNotifyUrlWebView implements IGatewayAppSiteWayWebView {
    @CjServiceRef
    IPayChannelService payChannelService;
    @CjServiceRef
    IChannelAccountService channelAccountService;
    @CjServiceRef
    IChannelBillService channelBillService;
    @CjServiceRef(refByName = "@.rabbitmq.producer.settle_recharge")
    IRabbitMQProducer notifyProducer;

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        frame.content().accept(new XwwwFormUrlencodedContentReciever() {
            @Override
            protected void done(Frame frame) throws CircuitException {
                doPost(frame, circuit);
            }
        });
    }

    private void doPost(Frame frame, Circuit circuit) throws CircuitException {
        CJSystem.logging().info(getClass(), String.format("支付宝异步通知:%s", frame));
        Map<String, String> params = new HashMap<String, String>();
        String[] keys = frame.enumParameterName();
        for (String key : keys) {
            String v = frame.parameter(key);
            params.put(key, v);
        }
        String bodyJson = params.get("body");
        Map<String, Object> body = new Gson().fromJson(bodyJson, HashMap.class);
        String channelAccount = (String) body.get("channelAccount");
        if (StringUtil.isEmpty(channelAccount)) {
            circuit.content().writeBytes("success".getBytes());//success等于放弃这类通知
            CJSystem.logging().info(getClass(), String.format("支付宝异步接收参数中未发现渠道账号"));
            return;
        }
        ChannelAccount account = channelAccountService.getAccount(channelAccount);
        if (account == null) {
            circuit.content().writeBytes("success".getBytes());//success等于放弃这类通知
            CJSystem.logging().info(getClass(), String.format("支付宝渠道账号不存在:%s", channelAccount));
            return;
        }
        String notify_id = params.get("notify_id");
        if (channelBillService.existsNotifyId(account.getChannel(), notify_id)) {
            CJSystem.logging().info(getClass(), String.format("重复收到标识为:%s 的通知，已丢弃", notify_id));
            circuit.content().writeBytes("success".getBytes());
            return;
        }
        String alipaypublicKey = account.getPublicKey();
        try {
            boolean flag = AlipaySignature.rsaCheckV1(params, alipaypublicKey, "utf-8", "RSA2");
            if (!flag) {
                circuit.content().writeBytes("failure".getBytes());
                CJSystem.logging().error(getClass(), "验签失败");
                return;
            }
            ChannelBill bill = channelAccountService.recharge(account, params, body);
            String out_trade_no = params.get("out_trade_no");
            CJSystem.logging().info(getClass(), String.format("验签成功，充值单号:%s", out_trade_no));
            circuit.content().writeBytes("success".getBytes());
            settleRecharge(bill);
        } catch (AlipayApiException e) {
            CJSystem.logging().error(getClass(), e);
            circuit.content().writeBytes("failure".getBytes());
            return;
        }

    }

    private void settleRecharge(ChannelBill bill) throws CircuitException {
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/trade/settle.mhub")
                .headers(new HashMap<String, Object>() {{
                    put("command", "recharge");
                    put("pay-channel", bill.getChannelPay());
                }})
                .build();

        notifyProducer.publish("wallet", properties, new Gson().toJson(bill).getBytes());
    }
}
