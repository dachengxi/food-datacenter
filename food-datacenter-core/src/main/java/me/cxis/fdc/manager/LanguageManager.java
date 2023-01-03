package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.LanguageDOMapper;
import me.cxis.fdc.dao.model.LanguageDO;
import org.springframework.stereotype.Component;

@Component
public class LanguageManager {

    @Resource
    private LanguageDOMapper languageDOMapper;

    public LanguageDO queryByCode(String languageCode) {
        return languageDOMapper.selectByCode(languageCode);
    }
}
