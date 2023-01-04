package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.BrandDOMapper;
import me.cxis.fdc.dao.mapper.BrandLanguageDOMapper;
import me.cxis.fdc.dao.model.BrandDO;
import me.cxis.fdc.dao.model.BrandLanguageDO;
import org.springframework.stereotype.Component;

@Component
public class BrandManager {

    @Resource
    private BrandDOMapper brandDOMapper;

    @Resource
    private BrandLanguageDOMapper brandLanguageDOMapper;

    public BrandDO queryById(Long brandId) {
        return brandDOMapper.selectByPrimaryKey(brandId);
    }

    public BrandLanguageDO queryLanguage(Long brandId, String languageCode) {
        return brandLanguageDOMapper.selectByBrandIdAndLanguageCode(brandId, languageCode);
    }
}
