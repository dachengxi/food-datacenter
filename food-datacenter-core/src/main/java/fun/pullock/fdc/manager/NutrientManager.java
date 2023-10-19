package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.NutrientDOMapper;
import fun.pullock.fdc.dao.model.NutrientDO;
import fun.pullock.fdc.dao.model.NutrientLanguageDO;
import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.mapper.NutrientLanguageDOMapper;
import org.springframework.stereotype.Component;

@Component
public class NutrientManager {

    @Resource
    private NutrientDOMapper nutrientDOMapper;

    @Resource
    private NutrientLanguageDOMapper nutrientLanguageDOMapper;

    public NutrientDO queryById(Long nutrientId) {
        return nutrientDOMapper.selectByPrimaryKey(nutrientId);
    }

    public NutrientLanguageDO queryLanguage(Long nutrientId, String languageCode) {
        return nutrientLanguageDOMapper.selectByNutrientIdAndLanguageCode(nutrientId, languageCode);
    }
}
