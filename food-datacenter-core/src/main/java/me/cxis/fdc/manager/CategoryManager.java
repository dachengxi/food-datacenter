package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.CategoryDOMapper;
import me.cxis.fdc.dao.mapper.CategoryLanguageDOMapper;
import me.cxis.fdc.dao.model.CategoryDO;
import me.cxis.fdc.dao.model.CategoryLanguageDO;
import org.springframework.stereotype.Component;

@Component
public class CategoryManager {

    @Resource
    private CategoryDOMapper categoryDOMapper;

    @Resource
    private CategoryLanguageDOMapper categoryLanguageDOMapper;

    public CategoryDO queryById(Long id) {
        return categoryDOMapper.selectByPrimaryKey(id);
    }

    public CategoryLanguageDO queryLanguage(Long categoryId, String languageCode) {
        return categoryLanguageDOMapper.selectByCategoryIdAndLanguageCode(categoryId, languageCode);
    }
}
