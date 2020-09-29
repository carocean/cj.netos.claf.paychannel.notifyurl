package cj.netos.claf.paychannel.notifyurl;

import cj.netos.claf.paychannel.notifyurl.model.ChannelAccount;

import java.util.Map;

public interface IChannelAccountService {
    ChannelAccount getAccount(String accountid);

    void recharge(ChannelAccount account, Map<String, String> params, Map<String, Object> body);

}
