package cj.netos.claf.paychannel.notifyurl;

import cj.netos.claf.paychannel.notifyurl.model.RechargeRecord;

public interface IRechargeRecordService {
    RechargeRecord getRecord(String sn);
}
