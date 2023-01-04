package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.CategoryLanguageDO;
import org.apache.ibatis.annotations.Param;

public interface CategoryLanguageDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CategoryLanguageDO row);

    int insertSelective(CategoryLanguageDO row);

    CategoryLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CategoryLanguageDO row);

    int updateByPrimaryKey(CategoryLanguageDO row);

    CategoryLanguageDO selectByCategoryIdAndLanguageCode(@Param("categoryId") Long categoryId, @Param("languageCode") String languageCode);
}