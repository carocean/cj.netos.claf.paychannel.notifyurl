package cj.netos.claf.paychannel.notifyurl.service;

import cj.netos.claf.paychannel.notifyurl.IPayChannelService;
import cj.netos.claf.paychannel.notifyurl.mapper.PayChannelMapper;
import cj.netos.claf.paychannel.notifyurl.model.PayChannel;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "@transaction")
@CjService(name = "payChannelService")
public class PayChannelService implements IPayChannelService {
    @CjServiceRef(refByName = "mybatis.cj.netos.claf.paychannel.notifyurl.mapper.PayChannelMapper")
    PayChannelMapper payChannelMapper;

    @CjTransaction
    @Override
    public PayChannel getPayChannel(String payChannelID) {
        return payChannelMapper.selectByPrimaryKey(payChannelID);
    }

}
