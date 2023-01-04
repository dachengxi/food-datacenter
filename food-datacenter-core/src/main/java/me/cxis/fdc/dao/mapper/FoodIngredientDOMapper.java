package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.FoodIngredientDO;

import java.util.List;

public interface FoodIngredientDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(FoodIngredientDO row);

    int insertSelective(FoodIngredientDO row);

    FoodIngredientDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodIngredientDO row);

    int updateByPrimaryKey(FoodIngredientDO row);

    List<FoodIngredientDO> selectByFoodId(Long foodId);
}