package cj.netos.claf.paychannel.notifyurl.model;

/**
 * Table: recharge_record
 */
public class RechargeRecord {
    /**
     * Column: sn
     * Remark: YYYYMMDD+交易流水（每天从1开始）
     */
    private String sn;

    /**
     * Column: person
     * Remark: 公众号
     */
    private String person;

    /**
     * Column: person_name
     * Remark: 公众名
     */
    private String personName;

    /**
     * Column: currency
     * Remark: 币种
     */
    private String currency;

    /**
     * Column: demand_amount
     * Remark: 要求冲值金额
     */
    private Long demandAmount;

    /**
     * Column: real_amount
     * Remark: 实际冲值发生额
     */
    private Long realAmount;

    /**
     * Column: to_channel_account
     * Remark: 支付到平台的哪个渠道账户，关联渠道账户id 根据pay_channel选择其下的平台收款渠道账户
     */
    private String toChannelAccount;

    /**
     * Column: pay_channel
     * Remark: 付款渠道，即充值方式，如支付宝，银联
     */
    private String payChannel;

    /**
     * Column: pay_account
     * Remark: 付款的账户，可能为空，如支付宝付款者为个人账户是记录不到的；但在网联方式下可以记录下用户从哪个银行卡付的款，因此将来接网联还需要建立用户-银行卡绑定表
     */
    private String payAccount;

    /**
     * Column: pay_terminal
     * Remark: 支付终端，如:app,  jsapi等
     */
    private String payTerminal;

    /**
     * Column: pay_openid
     * Remark: 支付用的第三方openid，与pay_terminal对应 主要用于兼容微信jsapi支付需要用到openid的问题
     */
    private String payOpenid;

    /**
     * Column: state
     * Remark: 0为创建；1为完成 是否出错看status，status记录当前步骤的状态
     */
    private Integer state;

    /**
     * Column: ctime
     * Remark: 创建时间
     */
    private String ctime;

    /**
     * Column: lutime
     * Remark: 最新修改时间
     */
    private String lutime;

    /**
     * Column: status
     * Remark: 订单完成时第三方渠道的返回码
     */
    private Integer status;

    /**
     * Column: message
     * Remark: 订单完成时第三方渠道的返回信息
     */
    private String message;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Long getDemandAmount() {
        return demandAmount;
    }

    public void setDemandAmount(Long demandAmount) {
        this.demandAmount = demandAmount;
    }

    public Long getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Long realAmount) {
        this.realAmount = realAmount;
    }

    public String getToChannelAccount() {
        return toChannelAccount;
    }

    public void setToChannelAccount(String toChannelAccount) {
        this.toChannelAccount = toChannelAccount == null ? null : toChannelAccount.trim();
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    public String getPayTerminal() {
        return payTerminal;
    }

    public void setPayTerminal(String payTerminal) {
        this.payTerminal = payTerminal == null ? null : payTerminal.trim();
    }

    public String getPayOpenid() {
        return payOpenid;
    }

    public void setPayOpenid(String payOpenid) {
        this.payOpenid = payOpenid == null ? null : payOpenid.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getLutime() {
        return lutime;
    }

    public void setLutime(String lutime) {
        this.lutime = lutime == null ? null : lutime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}