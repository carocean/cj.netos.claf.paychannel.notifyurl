package cj.netos.claf.paychannel.notifyurl.service;

import cj.netos.claf.paychannel.notifyurl.IChannelBillService;
import cj.netos.claf.paychannel.notifyurl.mapper.ChannelBillMapper;
import cj.netos.claf.paychannel.notifyurl.model.ChannelBillExample;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "@transaction")
@CjService(name = "channelBillService")
public class ChannelBillService implements IChannelBillService {
    @CjServiceRef(refByName = "mybatis.cj.netos.claf.paychannel.notifyurl.mapper.ChannelBillMapper")
    ChannelBillMapper channelBillMapper;

    @CjTransaction
    @Override
    public boolean existsNotifyId(String payChannel,String notify_id) {
        ChannelBillExample example = new ChannelBillExample();
        example.createCriteria().andNotifyIdEqualTo(notify_id);
        return channelBillMapper.countByExample(example) > 0;
    }
}
