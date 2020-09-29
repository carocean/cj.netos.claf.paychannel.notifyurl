package cj.netos.claf.paychannel.notifyurl.service;

import cj.netos.claf.paychannel.notifyurl.IChannelAccountService;
import cj.netos.claf.paychannel.notifyurl.IdWorker;
import cj.netos.claf.paychannel.notifyurl.WalletUtils;
import cj.netos.claf.paychannel.notifyurl.mapper.ChannelAccountMapper;
import cj.netos.claf.paychannel.notifyurl.mapper.ChannelBillMapper;
import cj.netos.claf.paychannel.notifyurl.model.ChannelAccount;
import cj.netos.claf.paychannel.notifyurl.model.ChannelBill;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
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

}
