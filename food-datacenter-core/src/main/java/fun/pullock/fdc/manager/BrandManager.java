package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.BrandDOMapper;
import fun.pullock.fdc.dao.mapper.BrandLanguageDOMapper;
import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.model.BrandDO;
import fun.pullock.fdc.dao.model.BrandLanguageDO;
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
