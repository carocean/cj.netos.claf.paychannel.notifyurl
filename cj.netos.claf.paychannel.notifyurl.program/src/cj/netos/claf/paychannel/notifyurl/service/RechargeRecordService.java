package cj.netos.claf.paychannel.notifyurl.service;

import cj.netos.claf.paychannel.notifyurl.IRechargeRecordService;
import cj.netos.claf.paychannel.notifyurl.mapper.RechargeRecordMapper;
import cj.netos.claf.paychannel.notifyurl.model.RechargeRecord;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "@transaction")
@CjService(name = "rechargeRecordService")
public class RechargeRecordService implements IRechargeRecordService {
    @CjServiceRef(refByName = "mybatis.cj.netos.claf.paychannel.notifyurl.mapper.RechargeRecordMapper")
    RechargeRecordMapper rechargeRecordMapper;

    @CjTransaction
    @Override
    public RechargeRecord getRecord(String sn) {
        return rechargeRecordMapper.selectByPrimaryKey(sn);
    }
}
