package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.UnitLanguageDO;

public interface UnitLanguageDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UnitLanguageDO row);

    int insertSelective(UnitLanguageDO row);

    UnitLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UnitLanguageDO row);

    int updateByPrimaryKey(UnitLanguageDO row);
}