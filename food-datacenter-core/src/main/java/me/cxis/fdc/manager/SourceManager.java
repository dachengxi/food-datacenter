package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.SourceDOMapper;
import me.cxis.fdc.dao.mapper.SourceLanguageDOMapper;
import me.cxis.fdc.dao.model.SourceDO;
import me.cxis.fdc.dao.model.SourceLanguageDO;
import org.springframework.stereotype.Component;

@Component
public class SourceManager {

    @Resource
    private SourceDOMapper sourceDOMapper;

    @Resource
    private SourceLanguageDOMapper sourceLanguageDOMapper;

    public SourceDO queryById(Long sourceId) {
        return sourceDOMapper.selectByPrimaryKey(sourceId);
    }

    public SourceLanguageDO queryLanguage(Long sourceId, String languageCode) {
        return sourceLanguageDOMapper.selectBySourceIdAndLanguageCode(sourceId, languageCode);
    }
}
