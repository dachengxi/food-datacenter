package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.NutrientDO;

public interface NutrientDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NutrientDO row);

    int insertSelective(NutrientDO row);

    NutrientDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NutrientDO row);

    int updateByPrimaryKey(NutrientDO row);
}