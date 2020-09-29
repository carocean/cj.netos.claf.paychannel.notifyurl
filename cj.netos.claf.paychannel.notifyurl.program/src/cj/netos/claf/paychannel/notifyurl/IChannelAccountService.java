package cj.netos.claf.paychannel.notifyurl;

import cj.netos.claf.paychannel.notifyurl.model.ChannelAccount;
import cj.netos.claf.paychannel.notifyurl.model.ChannelBill;

import java.util.Map;

public interface IChannelAccountService {
    ChannelAccount getAccount(String accountid);

    ChannelBill recharge(ChannelAccount account, Map<String, String> params, Map<String, Object> body);

}
