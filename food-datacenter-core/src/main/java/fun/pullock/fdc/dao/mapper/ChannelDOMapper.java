package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.ChannelDO;

public interface ChannelDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ChannelDO row);

    int insertSelective(ChannelDO row);

    ChannelDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelDO row);

    int updateByPrimaryKey(ChannelDO row);

    ChannelDO selectByCode(String channelCode);
}