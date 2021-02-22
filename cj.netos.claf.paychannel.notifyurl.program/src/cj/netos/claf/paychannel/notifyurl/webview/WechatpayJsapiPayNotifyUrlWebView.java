package cj.netos.claf.paychannel.notifyurl.webview;

import cj.netos.claf.paychannel.notifyurl.*;
import cj.netos.claf.paychannel.notifyurl.model.ChannelAccount;
import cj.netos.claf.paychannel.notifyurl.model.RechargeRecord;
import cj.netos.claf.paychannel.notifyurl.model.WechatpayMessage;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.ecm.net.io.MemoryContentReciever;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import com.rabbitmq.client.AMQP;

import java.util.HashMap;
import java.util.Map;

@CjService(name = "/wechat/jsapi_pay_notify.html")
public class WechatpayJsapiPayNotifyUrlWebView implements IGatewayAppSiteWayWebView {
    @CjServiceRef
    IPayChannelService payChannelService;
    @CjServiceRef
    IChannelAccountService channelAccountService;
    @CjServiceRef
    IChannelBillService channelBillService;
    @CjServiceRef
    IRechargeRecordService rechargeRecordService;
    @CjServiceRef(refByName = "@.rabbitmq.producer.settle")
    IRabbitMQProducer notifyProducer;
    @CjServiceSite
    IServiceSite serviceSite;

    /* 微信异步返回结果

    From-Who=httpSite
    Accept=
    User-Agent=Mozilla/4.0
    Host=nodespower.com:443
    From-Protocol=http
            protocol=HTTP/1.1
    Pragma=no-cache
            command=POST
    url=/payNotify/wechat/app_pay_notify.html
    Wechatpay-Timestamp=1613898837
    Wechatpay-Serial=31017060CA9811043802FC6316792E0B7001AEAE
    Wechatpay-Nonce=KeZjak9KBMKgIbcmDwOAGqQ7rUu1JMRg
    Wechatpay-Signature=Y1SKLcGj+TlodPR1DlwsgxJZUpG4aJLxKQVdKtt4UReApWuvY0+zfmMUddE15LCyxiE2ZetgWB0mmxSH+v4yQleqLxq7YTZO963LTh7dPmlo6Al7wVg8WsLqOp6P2liIDXcnObgZh7YMZZiutoJHY7CK3BtXIIbhp4S3rjkPaEK7omXhRgOVfOemvHzJ2sKRCPXHUHVR4w81WjqUjc7VPplgR9l7Z2XPda0Miz3nstOMG97juBt1ym6wn8VXxiXmo2HPeZnwc9mreXfI87VVuwD4SNf7+1FStNrARk381WW0PqeIyWpWY1Y3tCg4T4IlsDBjNSIuj7gPQ8/zGB8qAw==
    From-Pipeline-Name=7dcb996990d2fb3d-0000001a-00000002-4e7e6abf84c997a0-ef5800dd@payNotify
    X-Forwarded-For=121.51.58.168
    Content-Length=923
    X-Real-IP=121.51.58.168
    Content-Type=application/json

    内容：
    {
        "id":"69d85471-1f9b-5a4f-818e-e3076d7527b3",
        "create_time":"2021-02-21T17:58:32+08:00",
        "resource_type":"encrypt-resource",
        "event_type":"TRANSACTION.SUCCESS",
        "summary":"支付成功",
        "resource":{
            "original_type":"transaction",
            "algorithm":"AEAD_AES_256_GCM",
            "ciphertext":"gcB3DRjoqtHXn2i8pKY7rNJBZzu+lM2ChQ3EW81PBtShSCJBmg5NM489ekTaUwPkXgq+nmmbIEZ+95kujpc+OOO8Hcm3e2GKGOzdU+5G3PHAIxXSCKKCfoO1DpBZ7IqFlCwChSetsaNBe5gt6797p6dYs/4F6+dn4Rva7jqCgOMDSj3qEDyMcziKuDl8pUBZ2S0E87P+ih0Idgjp6mE4MacrpckC8kt+8N0leS7EX1ZRojlpVnlRxpA1PDKCnP9PsWOTeE3X8HnpUV0zjtsN1jfLxRicG/xPl08II1F7VrHRQz9FjScfckkNuJAWEO6zf4LmC9957zlAYsbQ30A3PG662bN68GztLdNLs4yflvFQiRaaYEwNYsSEIfLYAb2g6LG99H5dr6CYMwapXAE0fGmYu8YzL39Dn8TU/5WbeXsiHIbD+SskV/OA0fPcCQddMMAFX/ob9Ux+ukjy0SLJtZwc1aE7KscPjo2ZFLdBSYZqLvvN7INYzhSiAmnwo6c9PN9HzcVw9kNSl6QMFFBwm7vfgrF6C/LpNBmT7kdtJLKuwiXtTBehywxgJAvBLAbwRAD/iMgZ3dnNtN4mzQ==",
            "associated_data":"transaction",
            "nonce":"974L4YHTzrQI"
        }
    }
    解密后
    {
        "mchid":"1606337815",
        "appid":"wxf7be7c1a7c5fd8ed",
        "out_trade_no":"E1E73AC0B9508D4864F4047CC9D7EF24",
        "transaction_id":"4200000897202102211648715097",
        "trade_type":"APP",
        "trade_state":"SUCCESS",
        "trade_state_desc":"支付成功",
        "bank_type":"OTHERS",
        "attach":"",
        "success_time":"2021-02-21T19:08:13+08:00",
        "payer":{
            "openid":"or4tO6jJdn5jcv5n3rwmSN189HeU"
        },
        "amount":{
            "total":1,
            "payer_total":1,
            "currency":"CNY",
            "payer_currency":"CNY"
        }
    }
     */
    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        CJSystem.logging().info(getClass(), "微信异步通知：" + frame);
        frame.content().accept(new MemoryContentReciever() {
            @Override
            public void done(byte[] b, int pos, int length) throws CircuitException {
                super.done(b, pos, length);
                byte[] content = readFully();//请求的内容，请求头在frame中找
                String json = new String(content);
                Map<String, Object> data = new Gson().fromJson(json, HashMap.class);
//                CJSystem.logging().info(getClass(), data);
                if (!"TRANSACTION.SUCCESS".equals(data.get("event_type"))) {
                    CJSystem.logging().info(getClass(), "微信支付发来支堆失败的通知");
                    writeFail(circuit);
                    return;
                }
                String key = serviceSite.getProperty("wechat.pay.key");
                String notify_id = (String) data.get("id");
                Map<String, Object> resource = (Map<String, Object>) data.get("resource");
                String associated_data = (String) resource.get("associated_data");
                String ciphertext = (String) resource.get("ciphertext");
                String nonce = (String) resource.get("nonce");
                CJSystem.logging().info(WechatpayJsapiPayNotifyUrlWebView.this.getClass(), String.format("\nkey:%s,\nassociated_data:%s,\nciphertext:%s,\nnonce:%s", key, associated_data, ciphertext, nonce));

                try {
                    WxAPIV3AesUtil aesUtil = new WxAPIV3AesUtil(key.getBytes());
                    String decryptToString = aesUtil.decryptToString(associated_data.getBytes("UTF-8"), nonce.getBytes("UTF-8"), ciphertext);
                    WechatpayMessage message = new Gson().fromJson(decryptToString, WechatpayMessage.class);
                    CJSystem.logging().info(WechatpayJsapiPayNotifyUrlWebView.this.getClass(), message.getOut_trade_no());
                    doPost(frame, circuit, message, notify_id);
                    writeSuss(circuit);
                } catch (Exception e) {
                    circuit.status("500");
                    circuit.message(e.getMessage());
                    writeFail(circuit);
                    CJSystem.logging().error(WechatpayJsapiPayNotifyUrlWebView.this.getClass(), e);
                }
            }
        });
    }

    private void doPost(Frame frame, Circuit circuit, WechatpayMessage message, String notify_id) throws CircuitException {
        String out_trade_no = message.getOut_trade_no();
        long total_amount = message.getAmount().getTotal();
        Map<String, String> attach = new Gson().fromJson(message.getAttach(), HashMap.class);
        String rechargeRecordSn = attach.get("recharge-sn");
        RechargeRecord rechargeRecord = rechargeRecordService.getRecord(rechargeRecordSn);
        String channelAccount = rechargeRecord.getToChannelAccount();
        String person = rechargeRecord.getPerson();
        String personName = rechargeRecord.getPersonName();

        Map<String, String> settleMap = new HashMap<>();
        settleMap.put("person", person);
        settleMap.put("personName", personName);
        settleMap.put("record_sn", out_trade_no);
        settleMap.put("amount", total_amount + "");

        if (StringUtil.isEmpty(channelAccount)) {
            circuit.content().writeBytes("success".getBytes());//success等于放弃这类通知
            CJSystem.logging().info(getClass(), String.format("微信异步接收参数中未发现渠道账号"));
            settleMap.put("status", "404");
            settleMap.put("message", "微信异步接收参数中未发现渠道账号");
            settleRecharge(settleMap);
            circuit.status("500");
            circuit.message("微信异步接收参数中未发现渠道账号");
            writeFail(circuit);
            return;
        }
        ChannelAccount account = channelAccountService.getAccount(channelAccount);
        if (account == null) {
            circuit.content().writeBytes("success".getBytes());//success等于放弃这类通知
            CJSystem.logging().info(getClass(), String.format("微信渠道账号不存在:%s", channelAccount));
            settleMap.put("status", "404");
            settleMap.put("message", String.format("微信渠道账号不存在:%s", channelAccount));
            settleRecharge(settleMap);
            circuit.status("500");
            circuit.message("渠道账号不存在");
            writeFail(circuit);
            return;
        }
        if (channelBillService.existsNotifyId(account.getChannel(), notify_id)) {
            CJSystem.logging().info(getClass(), String.format("重复收到标识为:%s 的充值通知，已丢弃", notify_id));
            writeSuss(circuit);
            return;
        }
        try {
            Map<String, String> params = new HashMap<>();
            params.put("out_trade_no", out_trade_no);
            params.put("trade_no", message.getTransaction_id());
            params.put("total_amount", (total_amount / 100.00) + "");
            params.put("notify_id", notify_id);
            Map<String, Object> body = new HashMap<>();
            body.put("person", person);
            body.put("personName", personName);
            channelAccountService.recharge(account, params, body);
            CJSystem.logging().info(getClass(), String.format("处理成功，充值单号:%s", out_trade_no));

            settleMap.put("status", "200");
            settleMap.put("message", "ok");
            settleRecharge(settleMap);
            writeSuss(circuit);
        } catch (Exception e) {
            CJSystem.logging().error(getClass(), e);
            settleMap.put("status", "500");
            settleMap.put("message", e.getMessage());
            settleRecharge(settleMap);
            circuit.status("500");
            circuit.message(e.getMessage());
            writeFail(circuit);
            return;
        }

    }

    private void settleRecharge(Map<String, String> settleMap) throws CircuitException {
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/trade/settle.mhub")
                .headers(new HashMap<String, Object>() {{
                    put("command", "recharge");
                }})
                .build();
        try {
            notifyProducer.publish("wallet", properties, new Gson().toJson(settleMap).getBytes());
        } catch (Exception e) {
            CJSystem.logging().error(getClass(), e);
        }
    }


    private void writeFail(Circuit circuit) {
        Map<String, String> apply = new HashMap<>();
        //通知的应答给微信
        apply.put("code", circuit.status());
        apply.put("message", circuit.message());
        circuit.content().writeBytes(new Gson().toJson(apply).getBytes());
    }

    private void writeSuss(Circuit circuit) {
        Map<String, String> apply = new HashMap<>();
        //通知的应答给微信
        apply.put("code", "SUCCESS");
        apply.put("message", "成功");
        circuit.content().writeBytes(new Gson().toJson(apply).getBytes());
    }

}
