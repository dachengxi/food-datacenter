package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.ChannelLanguageDO;
import org.apache.ibatis.annotations.Param;

public interface ChannelLanguageDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ChannelLanguageDO row);

    int insertSelective(ChannelLanguageDO row);

    ChannelLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelLanguageDO row);

    int updateByPrimaryKey(ChannelLanguageDO row);

    ChannelLanguageDO selectByChannelIdAndLanguageCode(@Param("channelId") Long channelId, @Param("languageCode") String languageCode);
}