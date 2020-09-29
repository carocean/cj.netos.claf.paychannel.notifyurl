package cj.netos.claf.paychannel.notifyurl.mapper;

import cj.netos.claf.paychannel.notifyurl.model.ChannelBill;
import cj.netos.claf.paychannel.notifyurl.model.ChannelBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelBillMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ChannelBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ChannelBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ChannelBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ChannelBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ChannelBill> selectByExample(ChannelBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ChannelBill selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ChannelBill record, @Param("example") ChannelBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ChannelBill record, @Param("example") ChannelBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ChannelBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ChannelBill record);
}