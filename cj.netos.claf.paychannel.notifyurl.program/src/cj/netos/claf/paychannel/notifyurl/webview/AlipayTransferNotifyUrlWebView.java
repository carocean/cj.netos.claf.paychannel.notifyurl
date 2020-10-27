package cj.netos.claf.paychannel.notifyurl.webview;

import cj.netos.claf.paychannel.notifyurl.IChannelAccountService;
import cj.netos.claf.paychannel.notifyurl.IChannelBillService;
import cj.netos.claf.paychannel.notifyurl.IPayChannelService;
import cj.netos.claf.paychannel.notifyurl.IWithdrawService;
import cj.netos.claf.paychannel.notifyurl.model.ChannelAccount;
import cj.netos.claf.paychannel.notifyurl.model.WithdrawRecord;
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

@CjService(name = "/alipay/trans_notify.html")
public class AlipayTransferNotifyUrlWebView implements IGatewayAppSiteWayWebView {
    @CjServiceRef
    IPayChannelService payChannelService;
    @CjServiceRef
    IChannelAccountService channelAccountService;
    @CjServiceRef
    IChannelBillService channelBillService;
    @CjServiceRef
    IWithdrawService withdrawService;
    @CjServiceRef(refByName = "@.rabbitmq.producer.settle")
    IRabbitMQProducer notifyProducer;

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        frame.content().accept(new XwwwFormUrlencodedContentReciever() {
            @Override
            protected void done(Frame frame) throws CircuitException {
//                CJSystem.logging().info(getClass(), new String(frame.toBytes()));
                doPost(frame, circuit);
            }
        });

    }

    private void doPost(Frame frame, Circuit circuit) throws CircuitException {
        CJSystem.logging().info(getClass(), String.format("支付宝转账异步通知:%s", frame));
        Map<String, String> params = new HashMap<String, String>();
        String[] keys = frame.enumParameterName();
        for (String key : keys) {
            String v = frame.parameter(key);
            params.put(key, v);
        }
        String bodyJson = params.get("biz_content");
        String sign_type = params.get("sign_type");
        String charset = params.get("charset");
        Map<String, Object> contentMap = new Gson().fromJson(bodyJson, HashMap.class);

        String out_biz_no = (String) contentMap.get("out_biz_no");
        String trans_amount = (String) contentMap.get("trans_amount");
        Double amount = Double.valueOf(trans_amount) * 100.00;

        if (StringUtil.isEmpty(out_biz_no)) {
            circuit.content().writeBytes("success".getBytes());//success等于放弃这类通知
            CJSystem.logging().info(getClass(), String.format("支付宝异步接收参数中未发现外部订单号"));
            return;
        }

        WithdrawRecord record = withdrawService.getRecord(out_biz_no);

        if (record==null) {
            circuit.content().writeBytes("success".getBytes());//success等于放弃这类通知
            CJSystem.logging().info(getClass(), String.format("支付宝异步接收参数中不存在外部订单:%s",out_biz_no));
            return;
        }

        Map<String, String> settleMap = new HashMap<>();
        settleMap.put("person", record.getPerson());
        settleMap.put("personName", record.getPersonName());
        settleMap.put("record_sn", out_biz_no);
        settleMap.put("amount", amount.longValue() + "");

        String channelAccount=record.getPayAccount();
        ChannelAccount account = channelAccountService.getAccount(channelAccount);
        if (account == null) {
            circuit.content().writeBytes("success".getBytes());//success等于放弃这类通知
            CJSystem.logging().info(getClass(), String.format("支付宝渠道账号不存在:%s", channelAccount));
            settleMap.put("status", "404");
            settleMap.put("message", String.format("支付宝渠道账号不存在:%s", channelAccount));
            settleWithdraw(settleMap);
            return;
        }
        String notify_id = params.get("notify_id");
        if (channelBillService.existsNotifyId(account.getChannel(), notify_id)) {
            CJSystem.logging().info(getClass(), String.format("重复收到标识为:%s 的提现通知，已丢弃", notify_id));
            circuit.content().writeBytes("success".getBytes());
            return;
        }
        String alipayPublicCertPath = account.getCertPath2();
        try {
            boolean flag = AlipaySignature.certVerifyV1(params, alipayPublicCertPath, charset, sign_type);
            if (!flag) {
                circuit.content().writeBytes("failure".getBytes());
                CJSystem.logging().error(getClass(), "验签失败");
                settleMap.put("status", "404");
                settleMap.put("message", "验签失败");
                settleWithdraw(settleMap);
                return;
            }
            channelAccountService.withdraw(account, record, params, contentMap);
            CJSystem.logging().info(getClass(), String.format("验签成功，提现单号:%s", out_biz_no));
            circuit.content().writeBytes("success".getBytes());
            settleMap.put("status", "200");
            settleMap.put("message", "ok");
            settleWithdraw(settleMap);
        } catch (AlipayApiException e) {
            CJSystem.logging().error(getClass(), e);
            circuit.content().writeBytes("failure".getBytes());
            settleMap.put("status", e.getErrCode());
            settleMap.put("message", e.getErrMsg());
            settleWithdraw(settleMap);
            return;
        } catch (CircuitException e) {
            CJSystem.logging().error(getClass(), e);
            circuit.content().writeBytes("failure".getBytes());
            settleMap.put("status", e.getStatus());
            settleMap.put("message", e.getMessage());
            settleWithdraw(settleMap);
        }

    }

    private void settleWithdraw(Map<String, String> settleMap) throws CircuitException {
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/trade/settle.mhub")
                .headers(new HashMap<String, Object>() {{
                    put("command", "withdraw");
                }})
                .build();
        try {
            notifyProducer.publish("wallet", properties, new Gson().toJson(settleMap).getBytes());
        } catch (Exception e) {
            CJSystem.logging().error(getClass(), e);
        }
    }
}
