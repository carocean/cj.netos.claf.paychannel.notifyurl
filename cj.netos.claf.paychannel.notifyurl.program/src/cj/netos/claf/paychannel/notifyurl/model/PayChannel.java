package cj.netos.claf.paychannel.notifyurl.model;

/**
 * Table: pay_channel
 */
public class PayChannel {
    /**
     * Column: code
     * Remark: 渠道类型代码， WeChat:微信 Alipay:支付宝 yinLan:银联
     */
    private String code;

    /**
     * Column: name
     * Remark: 渠道的名称，如支付宝、微信、网联卡等
     */
    private String name;

    /**
     * Column: switch_fee_ratio
     * Remark: 费率开头 0为不执行费率 1为执行
     */
    private Integer switchFeeRatio;

    /**
     * Column: ctime
     * Remark: 注册时间
     */
    private String ctime;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSwitchFeeRatio() {
        return switchFeeRatio;
    }

    public void setSwitchFeeRatio(Integer switchFeeRatio) {
        this.switchFeeRatio = switchFeeRatio;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}