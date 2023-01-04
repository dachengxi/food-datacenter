package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.BrandOwnerDOMapper;
import me.cxis.fdc.dao.mapper.BrandOwnerLanguageDOMapper;
import me.cxis.fdc.dao.model.BrandOwnerDO;
import me.cxis.fdc.dao.model.BrandOwnerLanguageDO;
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
