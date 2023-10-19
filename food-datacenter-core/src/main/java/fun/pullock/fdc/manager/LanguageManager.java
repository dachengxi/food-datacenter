package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.LanguageDOMapper;
import fun.pullock.fdc.dao.model.LanguageDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class LanguageManager {

    @Resource
    private LanguageDOMapper languageDOMapper;

    public LanguageDO queryByCode(String languageCode) {
        return languageDOMapper.selectByCode(languageCode);
    }
}
