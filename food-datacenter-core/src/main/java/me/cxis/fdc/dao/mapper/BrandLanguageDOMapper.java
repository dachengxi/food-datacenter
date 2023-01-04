package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.BrandLanguageDO;
import org.apache.ibatis.annotations.Param;

public interface BrandLanguageDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BrandLanguageDO row);

    int insertSelective(BrandLanguageDO row);

    BrandLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BrandLanguageDO row);

    int updateByPrimaryKey(BrandLanguageDO row);

    BrandLanguageDO selectByBrandIdAndLanguageCode(@Param("brandId") Long brandId, @Param("languageCode") String languageCode);
}