package cj.netos.claf.paychannel.notifyurl;

import cj.netos.claf.paychannel.notifyurl.model.PayChannel;

public interface IPayChannelService {
    PayChannel getPayChannel(String payChannelID);
}
