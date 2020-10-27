package cj.netos.claf.paychannel.notifyurl;

import cj.netos.claf.paychannel.notifyurl.model.ChannelAccount;
import cj.netos.claf.paychannel.notifyurl.model.ChannelBill;
import cj.netos.claf.paychannel.notifyurl.model.WithdrawRecord;
import cj.studio.ecm.net.CircuitException;

import java.util.Map;

public interface IChannelAccountService {
    ChannelAccount getAccount(String accountid);

    ChannelBill recharge(ChannelAccount account, Map<String, String> params, Map<String, Object> body);

    ChannelBill withdraw(ChannelAccount account, WithdrawRecord record, Map<String, String> params, Map<String, Object> contentMap) throws CircuitException;

}
