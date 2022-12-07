package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.CategoryDOMapper;
import me.cxis.fdc.dao.model.CategoryDO;
import org.springframework.stereotype.Component;

@Component
public class CategoryManager {

    @Resource
    private CategoryDOMapper categoryDOMapper;

    public CategoryDO queryById(Long id) {
        return categoryDOMapper.selectByPrimaryKey(id);
    }
}
