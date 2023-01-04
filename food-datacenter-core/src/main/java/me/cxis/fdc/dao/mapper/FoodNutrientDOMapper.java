package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.FoodNutrientDO;

import java.util.List;

public interface FoodNutrientDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(FoodNutrientDO row);

    int insertSelective(FoodNutrientDO row);

    FoodNutrientDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodNutrientDO row);

    int updateByPrimaryKey(FoodNutrientDO row);

    List<FoodNutrientDO> selectByFoodId(Long foodId);
}