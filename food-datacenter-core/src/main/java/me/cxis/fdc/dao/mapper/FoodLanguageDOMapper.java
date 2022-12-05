package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.FoodLanguageDO;

public interface FoodLanguageDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FoodLanguageDO row);

    int insertSelective(FoodLanguageDO row);

    FoodLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodLanguageDO row);

    int updateByPrimaryKey(FoodLanguageDO row);
}