package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.UnitDO;

public interface UnitDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UnitDO row);

    int insertSelective(UnitDO row);

    UnitDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UnitDO row);

    int updateByPrimaryKey(UnitDO row);
}