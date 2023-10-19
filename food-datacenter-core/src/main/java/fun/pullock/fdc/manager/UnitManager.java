package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.UnitDOMapper;
import fun.pullock.fdc.dao.mapper.UnitLanguageDOMapper;
import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.model.UnitDO;
import fun.pullock.fdc.dao.model.UnitLanguageDO;
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
