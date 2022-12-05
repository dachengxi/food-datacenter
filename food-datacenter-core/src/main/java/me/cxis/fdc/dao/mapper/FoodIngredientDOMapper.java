package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.FoodIngredientDO;

public interface FoodIngredientDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FoodIngredientDO row);

    int insertSelective(FoodIngredientDO row);

    FoodIngredientDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodIngredientDO row);

    int updateByPrimaryKey(FoodIngredientDO row);
}