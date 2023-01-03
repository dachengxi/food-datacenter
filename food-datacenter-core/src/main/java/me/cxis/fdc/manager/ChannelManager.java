package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.ChannelDOMapper;
import me.cxis.fdc.dao.model.ChannelDO;
import org.springframework.stereotype.Component;

@Component
public class ChannelManager {

    @Resource
    private ChannelDOMapper channelDOMapper;

    public ChannelDO queryByCode(String channelCode) {
        return channelDOMapper.selectByCode(channelCode);
    }
}
