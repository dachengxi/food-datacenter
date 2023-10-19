package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.CategoryLanguageDOMapper;
import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.mapper.CategoryDOMapper;
import fun.pullock.fdc.dao.model.CategoryDO;
import fun.pullock.fdc.dao.model.CategoryLanguageDO;
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
