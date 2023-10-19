package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.BrandOwnerDOMapper;
import fun.pullock.fdc.dao.model.BrandOwnerDO;
import fun.pullock.fdc.dao.model.BrandOwnerLanguageDO;
import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.mapper.BrandOwnerLanguageDOMapper;
import org.springframework.stereotype.Component;

@Component
public class BrandOwnerManager {

    @Resource
    private BrandOwnerDOMapper brandOwnerDOMapper;

    @Resource
    private BrandOwnerLanguageDOMapper brandOwnerLanguageDOMapper;

    public BrandOwnerDO queryById(Long brandOwnerId) {
        return brandOwnerDOMapper.selectByPrimaryKey(brandOwnerId);
    }

    public BrandOwnerLanguageDO queryLanguage(Long brandOwnerId, String languageCode) {
        return brandOwnerLanguageDOMapper.selectByBrandOwnerIdAndLanguageCode(brandOwnerId, languageCode);
    }
}
