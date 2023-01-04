package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.NutrientDOMapper;
import me.cxis.fdc.dao.mapper.NutrientLanguageDOMapper;
import me.cxis.fdc.dao.model.NutrientDO;
import me.cxis.fdc.dao.model.NutrientLanguageDO;
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
