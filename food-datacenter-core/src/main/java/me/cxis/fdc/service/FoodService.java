package me.cxis.fdc.service;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.model.*;
import me.cxis.fdc.manager.*;
import me.cxis.fdc.model.*;
import me.cxis.fdc.model.param.FoodIdQueryParam;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private UnitManager unitManager;

    @Resource
    private SourceManager sourceManager;

    @Resource
    private FoodImageManager foodImageManager;

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

        // 食物份单位
        Long servingUnitId = foodDO.getServingUnitId();
        UnitDO servingUnitDO = unitManager.queryById(servingUnitId);
        setServingUnit(food, servingUnitDO);

        // 食物份的量的单位
        Long servingAmountUnitId = foodDO.getServingAmountUnitId();;
        UnitDO servingAmountUnitDO = unitManager.queryById(servingAmountUnitId);
        setServingAmountUnit(food, servingAmountUnitDO);

        // 食物来源
        Long sourceId = foodDO.getSourceId();
        SourceDO sourceDO = sourceManager.queryById(sourceId);
        setSource(food, sourceDO);

        // 食物图片
        List<FoodImageDO> foodImageDOS = foodImageManager.queryByFoodId(foodDO.getId());
        if (CollectionUtils.isNotEmpty(foodImageDOS)) {
            setFoodImages(food, foodImageDOS);
        }

        // TODO fodIngredients

        // TODO foodBrand

        // TODO foodNutrients


        // TODO 补全各个对象中的Channel信息

        // TODO language

        return food;
    }

    private void setFoodImages(Food food, List<FoodImageDO> foodImageDOS) {
        List<FoodImage> foodImages = foodImageDOS.stream().map(this::toFoodImage).toList();
        food.setFoodImages(foodImages);
    }

    private FoodImage toFoodImage(FoodImageDO source) {
        if (source == null) {
            return null;
        }

        FoodImage target = new FoodImage();
        target.setId(source.getId());
        target.setFoodId(source.getFoodId());
        target.setUrl(source.getUrl());
        target.setOrder(source.getOrder());
        return target;
    }

    private void setSource(Food food, SourceDO sourceDO) {
        Source source = toSource(sourceDO);
        food.setSource(source);
    }

    private Source toSource(SourceDO source) {
        if (source == null) {
            return null;
        }

        Source target = new Source();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setUrl(source.getUrl());
        return target;
    }

    private void setServingAmountUnit(Food food, UnitDO servingAmountUnitDO) {
        Unit unit = toUnit(servingAmountUnitDO);
        food.setServingAmountUnit(unit);
    }

    private void setServingUnit(Food food, UnitDO unitDO) {
        Unit unit = toUnit(unitDO);
        food.setServingUnit(unit);
    }

    private Unit toUnit(UnitDO source) {
        if (source == null) {
            return null;
        }

        Unit target = new Unit();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setType(source.getType());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setDisplayName(source.getDisplayName());
        target.setAbbreviation(source.getAbbreviation());
        return target;
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
