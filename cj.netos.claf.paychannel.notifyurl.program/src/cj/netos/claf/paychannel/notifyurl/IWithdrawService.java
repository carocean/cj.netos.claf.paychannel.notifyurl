package cj.netos.claf.paychannel.notifyurl;

import cj.netos.claf.paychannel.notifyurl.model.WithdrawRecord;

public interface IWithdrawService {

    WithdrawRecord getRecord(String out_biz_no);

}
