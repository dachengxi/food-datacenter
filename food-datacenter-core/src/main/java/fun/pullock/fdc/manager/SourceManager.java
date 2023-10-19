package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.SourceDOMapper;
import fun.pullock.fdc.dao.model.SourceDO;
import fun.pullock.fdc.dao.model.SourceLanguageDO;
import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.mapper.SourceLanguageDOMapper;
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
