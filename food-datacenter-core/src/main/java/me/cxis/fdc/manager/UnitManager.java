package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.UnitDOMapper;
import me.cxis.fdc.dao.model.UnitDO;
import org.springframework.stereotype.Component;

@Component
public class UnitManager {

    @Resource
    private UnitDOMapper unitDOMapper;

    public UnitDO queryById(Long unitId) {
        return unitDOMapper.selectByPrimaryKey(unitId);
    }
}
