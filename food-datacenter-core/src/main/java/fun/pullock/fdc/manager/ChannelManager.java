package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.ChannelLanguageDOMapper;
import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.mapper.ChannelDOMapper;
import fun.pullock.fdc.dao.model.ChannelDO;
import fun.pullock.fdc.dao.model.ChannelLanguageDO;
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
