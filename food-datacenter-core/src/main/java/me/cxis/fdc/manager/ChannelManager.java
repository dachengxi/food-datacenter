package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.ChannelDOMapper;
import me.cxis.fdc.dao.mapper.ChannelLanguageDOMapper;
import me.cxis.fdc.dao.model.ChannelDO;
import me.cxis.fdc.dao.model.ChannelLanguageDO;
import org.springframework.stereotype.Component;

@Component
public class ChannelManager {

    @Resource
    private ChannelDOMapper channelDOMapper;

    @Resource
    private ChannelLanguageDOMapper channelLanguageDOMapper;

    public ChannelDO queryByCode(String channelCode) {
        return channelDOMapper.selectByCode(channelCode);
    }

    public ChannelLanguageDO queryLanguage(Long channelId, String languageCode) {
        return channelLanguageDOMapper.selectByChannelIdAndLanguageCode(channelId, languageCode);
    }
}
