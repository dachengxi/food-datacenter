package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.FoodImageDO;

import java.util.List;

public interface FoodImageDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(FoodImageDO row);

    int insertSelective(FoodImageDO row);

    FoodImageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodImageDO row);

    int updateByPrimaryKey(FoodImageDO row);

    List<FoodImageDO> selectByFoodId(Long foodId);
}