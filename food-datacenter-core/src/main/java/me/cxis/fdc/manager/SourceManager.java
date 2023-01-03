package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.SourceDOMapper;
import me.cxis.fdc.dao.model.SourceDO;
import org.springframework.stereotype.Component;

@Component
public class SourceManager {

    @Resource
    private SourceDOMapper sourceDOMapper;

    public SourceDO queryById(Long sourceId) {
        return sourceDOMapper.selectByPrimaryKey(sourceId);
    }
}
