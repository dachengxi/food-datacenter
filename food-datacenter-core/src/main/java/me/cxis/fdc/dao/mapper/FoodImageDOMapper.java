package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.FoodImageDO;

public interface FoodImageDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FoodImageDO row);

    int insertSelective(FoodImageDO row);

    FoodImageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FoodImageDO row);

    int updateByPrimaryKey(FoodImageDO row);
}