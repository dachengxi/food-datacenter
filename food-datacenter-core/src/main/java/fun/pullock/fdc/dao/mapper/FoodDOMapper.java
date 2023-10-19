package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.FoodDO;

public interface FoodDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(FoodDO row);

    int insertSelective(FoodDO row);

    FoodDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodDO row);

    int updateByPrimaryKey(FoodDO row);
}