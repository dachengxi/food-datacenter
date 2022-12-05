package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.BrandOwnerLanguageDO;

public interface BrandOwnerLanguageDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BrandOwnerLanguageDO row);

    int insertSelective(BrandOwnerLanguageDO row);

    BrandOwnerLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BrandOwnerLanguageDO row);

    int updateByPrimaryKey(BrandOwnerLanguageDO row);
}