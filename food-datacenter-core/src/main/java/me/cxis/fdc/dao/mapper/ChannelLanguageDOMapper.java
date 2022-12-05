package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.ChannelLanguageDO;

public interface ChannelLanguageDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelLanguageDO row);

    int insertSelective(ChannelLanguageDO row);

    ChannelLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelLanguageDO row);

    int updateByPrimaryKey(ChannelLanguageDO row);
}