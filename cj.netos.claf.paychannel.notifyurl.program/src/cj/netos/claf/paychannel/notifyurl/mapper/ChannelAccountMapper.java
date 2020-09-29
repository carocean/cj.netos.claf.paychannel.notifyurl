package cj.netos.claf.paychannel.notifyurl.mapper;

import cj.netos.claf.paychannel.notifyurl.model.ChannelAccount;
import cj.netos.claf.paychannel.notifyurl.model.ChannelAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelAccountMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ChannelAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ChannelAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ChannelAccount record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ChannelAccount record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ChannelAccount> selectByExample(ChannelAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ChannelAccount selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ChannelAccount record, @Param("example") ChannelAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ChannelAccount record, @Param("example") ChannelAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ChannelAccount record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ChannelAccount record);

    void updateBalance(@Param(value = "id") String id,@Param(value = "balanceAmount") Long balanceAmount,@Param(value = "balanceUtime") String balanceUtime);
}