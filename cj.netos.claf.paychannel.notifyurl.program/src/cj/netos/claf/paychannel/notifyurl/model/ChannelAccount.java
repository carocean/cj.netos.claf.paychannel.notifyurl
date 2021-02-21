package cj.netos.claf.paychannel.notifyurl.model;

/**
 * Table: channel_account
 */
public class ChannelAccount {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: app_id
     * Remark: 即渠道给的appid
     */
    private String appId;

    /**
     * Column: mch_id
     * Remark: 商户号
     */
    private String mchId;

    /**
     * Column: channel
     * Remark: 归属的渠道代码，对应表pay_channel的code
     */
    private String channel;

    /**
     * Column: apply_terminal
     * Remark: 适用于终端。 比如微信，一个微信渠道即有移动app支付也有js支付，为了支持一个渠道下多个终端的支付接口，故设此字段 值有: - app - jsapi 等等 可以为空,默认是app
     */
    private String applyTerminal;

    /**
     * Column: balance_amount
     * Remark: 余额，单位为分
     */
    private Long balanceAmount;

    /**
     * Column: balance_utime
     * Remark: 余额更新时间
     */
    private String balanceUtime;

    /**
     * Column: limit_amount
     * Remark: 渠道限额,单位为分,0表示无限额
     */
    private Long limitAmount;

    /**
     * Column: service_url
     * Remark: 渠道的服务地址 全部以icon表示，但也为了兼容http格式，设定icons的格式为： icon:0xf1d7
     */
    private String serviceUrl;

    /**
     * Column: pay_notify_url
     * Remark: 支付状态通知地址
     */
    private String payNotifyUrl;

    /**
     * Column: trans_notify_url
     * Remark: 转账状态通知地址
     */
    private String transNotifyUrl;

    /**
     * Column: key_pubtime
     * Remark: 钥匙的发布时间
     */
    private String keyPubtime;

    /**
     * Column: key_expire
     * Remark: 钥匙的过期时间，用于提醒管理员，如果有，0表示永不过期
     */
    private Long keyExpire;

    /**
     * Column: use_cert
     * Remark: 是否采用证书或采用公钥 0为采用公钥 1为采用证书
     */
    private Integer useCert;

    /**
     * Column: public_key
     * Remark: 渠道给的公钥，一般是应用(app_id)的对应公钥
     */
    private String publicKey;

    /**
     * Column: private_key
     * Remark: 渠道给的私钥，一般是应用(app_id)的对应私钥
     */
    private String privateKey;

    /**
     * Column: api_v3_key
     * Remark: 专门用于微信。商户的apiv3密钥，即在设置商户api密钥时商户自定义的32位串
     */
    private String apiV3Key;

    /**
     * Column: mch_serial_no
     * Remark: 专用于微信。商户证书序列号，在商户后台账号中心的api安全中点查看证书可见
     */
    private String mchSerialNo;

    /**
     * Column: cert_path1
     * Remark: 如果第三方渠道采用证书，则不同渠道有不同的类型的证书，比如支付宝要求有：应用证书、支付证书、根证书，可分别用cert_path1,cert_path2，cert_path3来存储
     */
    private String certPath1;

    /**
     * Column: cert_path2
     * Remark: 如果第三方渠道采用证书，则不同渠道有不同的类型的证书，比如支付宝要求有：应用证书、支付证书、根证书，可分别用cert_path1,cert_path2，cert_path3来存储
     */
    private String certPath2;

    /**
     * Column: cert_path3
     * Remark: 如果第三方渠道采用证书，则不同渠道有不同的类型的证书，比如支付宝要求有：应用证书、支付证书、根证书，可分别用cert_path1,cert_path2，cert_path3来存储
     */
    private String certPath3;

    /**
     * Column: cert_path4
     * Remark: 如果第三方渠道采用证书，则不同渠道有不同的类型的证书，比如支付宝要求有：应用证书、支付证书、根证书，可分别用cert_path1,cert_path2，cert_path3来存储
     */
    private String certPath4;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getApplyTerminal() {
        return applyTerminal;
    }

    public void setApplyTerminal(String applyTerminal) {
        this.applyTerminal = applyTerminal == null ? null : applyTerminal.trim();
    }

    public Long getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Long balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getBalanceUtime() {
        return balanceUtime;
    }

    public void setBalanceUtime(String balanceUtime) {
        this.balanceUtime = balanceUtime == null ? null : balanceUtime.trim();
    }

    public Long getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Long limitAmount) {
        this.limitAmount = limitAmount;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl == null ? null : serviceUrl.trim();
    }

    public String getPayNotifyUrl() {
        return payNotifyUrl;
    }

    public void setPayNotifyUrl(String payNotifyUrl) {
        this.payNotifyUrl = payNotifyUrl == null ? null : payNotifyUrl.trim();
    }

    public String getTransNotifyUrl() {
        return transNotifyUrl;
    }

    public void setTransNotifyUrl(String transNotifyUrl) {
        this.transNotifyUrl = transNotifyUrl == null ? null : transNotifyUrl.trim();
    }

    public String getKeyPubtime() {
        return keyPubtime;
    }

    public void setKeyPubtime(String keyPubtime) {
        this.keyPubtime = keyPubtime == null ? null : keyPubtime.trim();
    }

    public Long getKeyExpire() {
        return keyExpire;
    }

    public void setKeyExpire(Long keyExpire) {
        this.keyExpire = keyExpire;
    }

    public Integer getUseCert() {
        return useCert;
    }

    public void setUseCert(Integer useCert) {
        this.useCert = useCert;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    public String getApiV3Key() {
        return apiV3Key;
    }

    public void setApiV3Key(String apiV3Key) {
        this.apiV3Key = apiV3Key == null ? null : apiV3Key.trim();
    }

    public String getMchSerialNo() {
        return mchSerialNo;
    }

    public void setMchSerialNo(String mchSerialNo) {
        this.mchSerialNo = mchSerialNo == null ? null : mchSerialNo.trim();
    }

    public String getCertPath1() {
        return certPath1;
    }

    public void setCertPath1(String certPath1) {
        this.certPath1 = certPath1 == null ? null : certPath1.trim();
    }

    public String getCertPath2() {
        return certPath2;
    }

    public void setCertPath2(String certPath2) {
        this.certPath2 = certPath2 == null ? null : certPath2.trim();
    }

    public String getCertPath3() {
        return certPath3;
    }

    public void setCertPath3(String certPath3) {
        this.certPath3 = certPath3 == null ? null : certPath3.trim();
    }

    public String getCertPath4() {
        return certPath4;
    }

    public void setCertPath4(String certPath4) {
        this.certPath4 = certPath4 == null ? null : certPath4.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}