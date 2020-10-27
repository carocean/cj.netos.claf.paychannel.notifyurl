package cj.netos.claf.paychannel.notifyurl.service;

import cj.netos.claf.paychannel.notifyurl.IWithdrawService;
import cj.netos.claf.paychannel.notifyurl.mapper.WithdrawRecordMapper;
import cj.netos.claf.paychannel.notifyurl.model.WithdrawRecord;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "@transaction")
@CjService(name = "withdrawService")
public class WithdrawService implements IWithdrawService {
    @CjServiceRef(refByName = "mybatis.cj.netos.claf.paychannel.notifyurl.mapper.WithdrawRecordMapper")
    WithdrawRecordMapper withdrawRecordMapper;

    @CjTransaction
    @Override
    public WithdrawRecord getRecord(String out_biz_no) {
        return withdrawRecordMapper.selectByPrimaryKey(out_biz_no);
    }
}
