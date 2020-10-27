package cj.netos.claf.paychannel.notifyurl.service;

import cj.netos.claf.paychannel.notifyurl.IChannelAccountService;
import cj.netos.claf.paychannel.notifyurl.IdWorker;
import cj.netos.claf.paychannel.notifyurl.WalletUtils;
import cj.netos.claf.paychannel.notifyurl.mapper.ChannelAccountMapper;
import cj.netos.claf.paychannel.notifyurl.mapper.ChannelBillMapper;
import cj.netos.claf.paychannel.notifyurl.model.ChannelAccount;
import cj.netos.claf.paychannel.notifyurl.model.ChannelBill;
import cj.netos.claf.paychannel.notifyurl.model.WithdrawRecord;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.Calendar;
import java.util.Map;

@CjBridge(aspects = "@transaction")
@CjService(name = "channelAccountService")
public class ChannelAccountService implements IChannelAccountService {
    @CjServiceRef(refByName = "mybatis.cj.netos.claf.paychannel.notifyurl.mapper.ChannelAccountMapper")
    ChannelAccountMapper channelAccountMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.claf.paychannel.notifyurl.mapper.ChannelBillMapper")
    ChannelBillMapper channelBillMapper;

    @CjTransaction
    @Override
    public ChannelAccount getAccount(String accountid) {
        return channelAccountMapper.selectByPrimaryKey(accountid);
    }

    /*
        gmt_create=2020-09-29 00:30:38
        charset=utf-8
        seller_email=609927412@qq.com
        subject=向地微充值
        sign=N5Udtn9hgTdpKXWY2E9D90CR/paEvEcGoJbqro3iaqn0FGFPIboRx4XSv2bJoW3wmubktVhJzg02mEbFU+KwaupggeV88S+yaYlrl73+jsINa1LzB+dmOVGkGVFT2QNL24EfFk1n7WFe179/qXEHHs1WqlxQVfB3p54+W3P8tqbqg+Ea3w4aqA+lEyyI2iLhjrwHT1JmGtaVM/5Ut7j2rkC5JX79q6mjzt8Zw4XViq/nmwEHFvhJiiqAadL3zKUtSN6Ucr/q8c7RscC4//GOCP0TUGfQYmktbjbllkRLPIKEZZ/k5wnyRIhF1Bv33YunyyAGPL5mG1QJA0Y9b/bYFw==
        body={"demandAmount":2,"channelAccount":"6F20C2145F8631D236444A993A43A9BA"}
        buyer_id=2088902191888570
        invoice_amount=0.02
        notify_id=2020092900222003039088571451043674
        fund_bill_list=[{"amount":"0.02","fundChannel":"ALIPAYACCOUNT"}]
        notify_type=trade_status_sync
        trade_status=TRADE_SUCCESS
        receipt_amount=0.02
        app_id=2021001198622080
        buyer_pay_amount=0.02
        sign_type=RSA2
        seller_id=2088831336090722
        gmt_payment=2020-09-29 00:30:39
        notify_time=2020-09-29 09:58:42
        version=1.0
        out_trade_no=54F4349974272141C88608BC248AFDF0
        total_amount=0.02
        trade_no=2020092922001488571408372130
        auth_app_id=2021001198622080
        buyer_logon_id=180****7655
        point_amount=0.00
     */
    @CjTransaction
    @Override
    public ChannelBill recharge(ChannelAccount account, Map<String, String> params, Map<String, Object> body) {
        String out_trade_no = params.get("out_trade_no");
        String trade_no = params.get("trade_no");
        String total_amount = params.get("total_amount");
        String notify_id = params.get("notify_id");
        String person = (String) body.get("person");
        String personName = (String) body.get("personName");
        Double amount = Double.valueOf(total_amount) * 100.00;

        ChannelBill bill = new ChannelBill();
        bill.setSn(new IdWorker().nextId());
        bill.setNotifyId(notify_id);
        bill.setChannelPay(account.getChannel());
        bill.setPerson(person);
        bill.setPersonName(personName);
        bill.setChannelAccount(account.getId());
        bill.setCtime(WalletUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        bill.setCurrency("CNY");
        bill.setTitle("充值");
        bill.setRefSn(out_trade_no);
        bill.setOrder(0);
        bill.setRefChSn(trade_no);
        bill.setAmount(amount.longValue());
        bill.setBalance(account.getBalanceAmount() + bill.getAmount());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        bill.setYear(calendar.get(Calendar.YEAR));
        bill.setMonth(calendar.get(Calendar.MONTH));
        bill.setDay(calendar.get(Calendar.DAY_OF_MONTH));
        int season = calendar.get(Calendar.MONTH) % 4;
        bill.setSeason(season);

        bill.setWorkday(WalletUtils.dateTimeToDay(System.currentTimeMillis()));

        channelBillMapper.insert(bill);

        channelAccountMapper.updateBalance(account.getId(), bill.getBalance(), bill.getCtime());

        return bill;
    }

    /*
    charset=UTF-8
biz_content={"pay_date":"2020-10-27 19:30:17","biz_scene":"DIRECT_TRANSFER","action_type":"FINISH","pay_fund_order_id":"20201027110070001506720033243552","origin_interface":"alipay.fund.trans.uni.transfer","out_biz_no":"CECBFA5D00DED624CBC0E77266103BE4","trans_amount":"1.00","product_code":"TRANS_ACCOUNT_NO_PWD","order_id":"20201027110070000006720030209273","status":"SUCCESS"}
utc_timestamp=1603799743231
sign=UNCM8Ycxz9U93iD7GAUM+2dZQ7L+utwca6mE5mzJUW0X0jj86cpg/lt4Zj1sNV82KYJoNrUxs8gTF8eQLgm5vw+KRFcUzZahi2ls42z6YxoB1A9tiMnkIY/OD8qwCsH7q6jDWQH9d2MKJqK8YPxqf+OwaoaaxqkRCKc2rA2sVU05/ZsipQUJ30DLzY2NnGj0FhPFxuCILyQ4OQSYL+yTiRWNp9qVEi/Q+SSo8xr80yV7xIYq4r9ipOXqZeLzZNM5YLEVRPbLg7zIdMl0YkDhkU9MpgfY9uGaE+XTTWo5VfBQdZegqlmNbM8TDwaVOr3lOncz8I+mxOs4VBFqxYUCoA==
app_id=2021001198622080
version=1.1
sign_type=RSA2
notify_id=2020102700222193017027581427329881
msg_method=alipay.fund.trans.order.changed
     */
    @CjTransaction
    public ChannelBill withdraw(ChannelAccount account, WithdrawRecord record, Map<String, String> params, Map<String, Object> contentMap) throws CircuitException {
        String out_trade_no = record.getSn();
        String order_id = (String) contentMap.get("order_id");
        String trans_amount = (String) contentMap.get("trans_amount");
        String notify_id = params.get("notify_id");
        String person = record.getPerson();
        String personName = record.getPersonName();
        Double amount = Double.valueOf(trans_amount) * 100.00;
        if (amount.longValue() > account.getBalanceAmount()) {
            throw new CircuitException("800","系统错误，请稍后再提");
        }
        ChannelBill bill = new ChannelBill();
        bill.setSn(new IdWorker().nextId());
        bill.setNotifyId(notify_id);
        bill.setChannelPay(account.getChannel());
        bill.setPerson(person);
        bill.setPersonName(personName);
        bill.setChannelAccount(account.getId());
        bill.setCtime(WalletUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        bill.setCurrency("CNY");
        bill.setTitle("提现");
        bill.setRefSn(out_trade_no);
        bill.setOrder(1);
        bill.setRefChSn(order_id);
        bill.setAmount(amount.longValue() * -1);
        bill.setBalance(account.getBalanceAmount() + bill.getAmount());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        bill.setYear(calendar.get(Calendar.YEAR));
        bill.setMonth(calendar.get(Calendar.MONTH));
        bill.setDay(calendar.get(Calendar.DAY_OF_MONTH));
        int season = calendar.get(Calendar.MONTH) % 4;
        bill.setSeason(season);

        bill.setWorkday(WalletUtils.dateTimeToDay(System.currentTimeMillis()));

        channelBillMapper.insert(bill);

        channelAccountMapper.updateBalance(account.getId(), bill.getBalance(), bill.getCtime());

        return bill;
    }
}
