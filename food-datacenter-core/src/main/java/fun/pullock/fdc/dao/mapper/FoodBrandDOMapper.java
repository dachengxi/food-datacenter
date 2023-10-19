package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.FoodBrandDO;

public interface FoodBrandDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(FoodBrandDO row);

    int insertSelective(FoodBrandDO row);

    FoodBrandDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodBrandDO row);

    int updateByPrimaryKey(FoodBrandDO row);

    FoodBrandDO selectByFoodId(Long foodId);
}