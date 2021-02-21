package cj.netos.claf.paychannel.notifyurl.model;

public class WechatpayMessage {
    String mchid;
    String appid;
    String out_trade_no;
    String transaction_id;
    String trade_type;
    String trade_state;
    String trade_state_desc;
    String bank_type;
    String attach;
    String success_time;
    WechatpayPayer payer;
    WechatpayAmountInfo amount;

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public String getTrade_state_desc() {
        return trade_state_desc;
    }

    public void setTrade_state_desc(String trade_state_desc) {
        this.trade_state_desc = trade_state_desc;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time(String success_time) {
        this.success_time = success_time;
    }

    public WechatpayPayer getPayer() {
        return payer;
    }

    public void setPayer(WechatpayPayer payer) {
        this.payer = payer;
    }

    public WechatpayAmountInfo getAmount() {
        return amount;
    }

    public void setAmount(WechatpayAmountInfo amount) {
        this.amount = amount;
    }
}
