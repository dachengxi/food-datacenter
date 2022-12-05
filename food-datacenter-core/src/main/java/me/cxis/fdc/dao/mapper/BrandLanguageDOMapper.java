package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.BrandLanguageDO;

public interface BrandLanguageDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BrandLanguageDO row);

    int insertSelective(BrandLanguageDO row);

    BrandLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BrandLanguageDO row);

    int updateByPrimaryKey(BrandLanguageDO row);
}