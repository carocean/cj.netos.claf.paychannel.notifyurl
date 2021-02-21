package cj.netos.claf.paychannel.notifyurl.model;

public class  WechatpayAmountInfo{
    long total;
    long payer_total;
    String currency;
    String payer_currency;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPayer_total() {
        return payer_total;
    }

    public void setPayer_total(long payer_total) {
        this.payer_total = payer_total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPayer_currency() {
        return payer_currency;
    }

    public void setPayer_currency(String payer_currency) {
        this.payer_currency = payer_currency;
    }
}