package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.CategoryDO;

public interface CategoryDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CategoryDO row);

    int insertSelective(CategoryDO row);

    CategoryDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CategoryDO row);

    int updateByPrimaryKey(CategoryDO row);
}