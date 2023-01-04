package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.UnitDOMapper;
import me.cxis.fdc.dao.mapper.UnitLanguageDOMapper;
import me.cxis.fdc.dao.model.UnitDO;
import me.cxis.fdc.dao.model.UnitLanguageDO;
import org.springframework.stereotype.Component;

@Component
public class UnitManager {

    @Resource
    private UnitDOMapper unitDOMapper;

    @Resource
    private UnitLanguageDOMapper unitLanguageDOMapper;

    public UnitDO queryById(Long unitId) {
        return unitDOMapper.selectByPrimaryKey(unitId);
    }

    public UnitLanguageDO queryLanguage(Long unitId, String languageCode) {
        return unitLanguageDOMapper.selectByUnitIdAndLanguageCode(unitId, languageCode);
    }
}
