package me.cxis.fdc.service;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.model.CategoryDO;
import me.cxis.fdc.dao.model.ChannelDO;
import me.cxis.fdc.dao.model.FoodDO;
import me.cxis.fdc.dao.model.LanguageDO;
import me.cxis.fdc.manager.CategoryManager;
import me.cxis.fdc.manager.ChannelManager;
import me.cxis.fdc.manager.FoodManager;
import me.cxis.fdc.manager.LanguageManager;
import me.cxis.fdc.model.Category;
import me.cxis.fdc.model.Food;
import me.cxis.fdc.model.param.FoodIdQueryParam;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Resource
    private FoodManager foodManager;

    @Resource
    private ChannelManager channelManager;

    @Resource
    private LanguageManager languageManager;

    @Resource
    private CategoryManager categoryManager;

    public boolean add() {
        return foodManager.add();
    }

    public String queryFoodName(Long id) {
        FoodDO foodDO = foodManager.queryById(id);
        if (foodDO == null) {
            return null;
        }

        return foodDO.getName();
    }

    public Food queryById(FoodIdQueryParam param) {
        String channelCode = param.getChannel();
        ChannelDO channelDO = channelManager.queryByCode(channelCode);
        if (channelDO == null) {
            // TODO
            return null;
        }

        String languageCode = param.getLanguageCode();
        LanguageDO languageDO = languageManager.queryByCode(languageCode);
        if (languageDO == null) {
            // TODO
            return null;
        }

        Long id = param.getId();

        // 查询食物
        FoodDO foodDO = foodManager.queryById(id);
        if (foodDO == null) {
            return null;
        }

        // 食物基础属性
        Food food = toBaseFood(foodDO);

        // 食物分类
        Long categoryId = foodDO.getCategoryId();
        CategoryDO categoryDO = categoryManager.queryById(categoryId);

        setCategory(food, categoryDO);

        // TODO

        return food;
    }

    private void setCategory(Food food, CategoryDO categoryDO) {
        Category category = toCategory(categoryDO);
        food.setCategory(category);
    }

    private Category toCategory(CategoryDO source) {
        if (source == null) {
            return null;
        }

        Category target = new Category();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    private Food toBaseFood(FoodDO source) {
        if (source == null) {
            return null;
        }

        Food target = new Food();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setType(source.getType());
        target.setServing(source.getServing());
        target.setServingValue(source.getServingValue());
        target.setServingAmount(source.getServingAmount());
        target.setSourceCode(source.getSourceCode());
        target.setBranded(source.getBranded());
        return target;
    }
}
