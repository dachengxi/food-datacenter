package me.cxis.fdc.service;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.model.*;
import me.cxis.fdc.enums.FoodType;
import me.cxis.fdc.manager.*;
import me.cxis.fdc.model.*;
import me.cxis.fdc.model.param.FoodIdQueryParam;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Resource
    private FoodIngredientManager foodIngredientManager;

    @Resource
    private FoodBrandManager foodBrandManager;

    @Resource
    private BrandManager brandManager;

    @Resource
    private BrandOwnerManager brandOwnerManager;

    @Resource
    private FoodNutrientManager foodNutrientManager;

    @Resource
    private NutrientManager nutrientManager;


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

        // 渠道信息
        Channel channel = toChannel(channelDO);

        LanguageDO defaultLanguageDO = languageManager.queryByCode(channel.getDefaultLanguageCode());
        channel.setDefaultLanguage(toLanguage(defaultLanguageDO));

        food.setChannel(channel);

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

        // 食物组成
        if (foodDO.getType() == FoodType.COMBINED.getType()) {
            List<FoodIngredientDO> ingredientDOS = foodIngredientManager.queryByFoodId(foodDO.getId());
            if (CollectionUtils.isNotEmpty(ingredientDOS)) {
                setFoodIngredients(food, ingredientDOS, param);
            }
        }

        // 品牌
        if (foodDO.getBranded()) {
            FoodBrandDO foodBrandDO = foodBrandManager.queryByFoodId(foodDO.getId());
            if (foodBrandDO != null) {
                FoodBrand foodBrand = toFoodBrand(foodBrandDO);
                food.setFoodBrand(foodBrand);
            }
        }

        // 营养成分
        List<FoodNutrientDO> foodNutrientDOS = foodNutrientManager.queryByFoodId(foodDO.getId());
        if (CollectionUtils.isNotEmpty(foodNutrientDOS)) {
            List<FoodNutrient> foodNutrients = foodNutrientDOS.stream().map(this::toFoodNutrient).toList();
            // TODO 排序
            food.setFoodNutrients(foodNutrients);
        }

        // language
        if (!languageCode.equals(channel.getDefaultLanguageCode())) {
            setLanguage(food, languageCode);
        }

        return food;
    }

    private void setLanguage(Food food, String languageCode) {
        FoodLanguageDO foodLanguageDO = foodManager.queryLanguage(food.getId(), languageCode);
        if (foodLanguageDO != null) {
            food.setName(foodLanguageDO.getName());
            food.setDescription(foodLanguageDO.getDescription());
        }

        Category category = food.getCategory();
        CategoryLanguageDO categoryLanguageDO = categoryManager.queryLanguage(category.getId(), languageCode);
        if (categoryLanguageDO != null) {
            category.setName(categoryLanguageDO.getName());
            category.setDescription(categoryLanguageDO.getDescription());
        }

        Channel channel = food.getChannel();
        ChannelLanguageDO channelLanguageDO = channelManager.queryLanguage(channel.getId(), languageCode);
        if (channelLanguageDO != null) {
            channel.setName(channelLanguageDO.getName());
            channel.setDescription(channelLanguageDO.getDescription());
        }

        Unit servingUnit = food.getServingUnit();
        UnitLanguageDO servingUnitLanguageDO = unitManager.queryLanguage(servingUnit.getId(), languageCode);
        if (servingUnitLanguageDO != null) {
            servingUnit.setName(servingUnitLanguageDO.getName());
            servingUnit.setDescription(servingUnitLanguageDO.getDescription());
            servingUnit.setDisplayName(servingUnitLanguageDO.getDisplayName());
            servingUnit.setAbbreviation(servingUnitLanguageDO.getAbbreviation());
        }

        Unit servingAmountUnit = food.getServingAmountUnit();
        UnitLanguageDO servingAmountUnitLanguageDO = unitManager.queryLanguage(servingUnit.getId(), languageCode);
        if (servingAmountUnitLanguageDO != null) {
            servingAmountUnit.setName(servingAmountUnitLanguageDO.getName());
            servingAmountUnit.setDescription(servingAmountUnitLanguageDO.getDescription());
            servingAmountUnit.setDisplayName(servingAmountUnitLanguageDO.getDisplayName());
            servingUnit.setAbbreviation(servingAmountUnitLanguageDO.getAbbreviation());
        }

        List<FoodIngredient> foodIngredients = food.getFoodIngredients();
        if (CollectionUtils.isNotEmpty(foodIngredients)) {
            for (FoodIngredient foodIngredient : foodIngredients) {
                Food ingredientFood = foodIngredient.getIngredientFood();
                FoodLanguageDO ingredientFoodLanguageDO = foodManager.queryLanguage(ingredientFood.getId(), languageCode);
                if (ingredientFoodLanguageDO != null) {
                    ingredientFood.setName(ingredientFoodLanguageDO.getName());
                    ingredientFood.setDescription(ingredientFoodLanguageDO.getDescription());
                }
            }
        }

        if (food.getBranded()) {
            FoodBrand foodBrand = food.getFoodBrand();
            Unit packageWeightUnit = foodBrand.getPackageWeightUnit();
            if (packageWeightUnit != null) {
                UnitLanguageDO packageWeightUnitLanguageDO = unitManager.queryLanguage(packageWeightUnit.getId(), languageCode);
                if (packageWeightUnitLanguageDO != null) {
                    packageWeightUnit.setName(packageWeightUnitLanguageDO.getName());
                    packageWeightUnit.setDescription(packageWeightUnitLanguageDO.getDescription());
                    packageWeightUnit.setDisplayName(packageWeightUnitLanguageDO.getDisplayName());
                    packageWeightUnit.setAbbreviation(packageWeightUnitLanguageDO.getAbbreviation());
                }
            }

            Brand brand = foodBrand.getBrand();
            BrandLanguageDO brandLanguageDO = brandManager.queryLanguage(brand.getId(), languageCode);
            if (brandLanguageDO != null) {
                brand.setName(brandLanguageDO.getName());
            }

            BrandOwner brandOwner = brand.getBrandOwner();
            BrandOwnerLanguageDO brandOwnerLanguageDO = brandOwnerManager.queryLanguage(brandOwner.getId(), languageCode);
            if (brandOwnerLanguageDO != null) {
                brandOwner.setName(brandOwnerLanguageDO.getName());
            }
        }

        List<FoodNutrient> foodNutrients = food.getFoodNutrients();
        if (CollectionUtils.isNotEmpty(foodNutrients)) {
            for (FoodNutrient foodNutrient : foodNutrients) {
                Nutrient nutrient = foodNutrient.getNutrient();
                NutrientLanguageDO nutrientLanguageDO = nutrientManager.queryLanguage(nutrient.getId(), languageCode);
                if (nutrientLanguageDO != null) {
                    nutrient.setName(nutrientLanguageDO.getName());
                    nutrient.setDescription(nutrientLanguageDO.getDescription());
                    nutrient.setDisplayName(nutrientLanguageDO.getDisplayName());
                    nutrient.setAbbreviation(nutrientLanguageDO.getAbbreviation());
                }

                Unit nutrientUnit = foodNutrient.getUnit();
                UnitLanguageDO nutrientUnitLanguageDO = unitManager.queryLanguage(nutrientUnit.getId(), languageCode);
                if (nutrientUnitLanguageDO != null) {
                    nutrientUnit.setName(nutrientUnitLanguageDO.getName());
                    nutrientUnit.setDescription(nutrientUnitLanguageDO.getDescription());
                    nutrientUnit.setDisplayName(nutrientUnitLanguageDO.getDisplayName());
                    nutrientUnit.setAbbreviation(nutrientUnitLanguageDO.getAbbreviation());
                }
            }
        }

        Source source = food.getSource();
        SourceLanguageDO sourceLanguageDO = sourceManager.queryLanguage(source.getId(), languageCode);
        if (sourceLanguageDO != null) {
            source.setName(sourceLanguageDO.getName());
            source.setDescription(sourceLanguageDO.getDescription());
        }
    }

    private Language toLanguage(LanguageDO source) {
        if (source == null) {
            return null;
        }

        Language target = new Language();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDisplayName(source.getDisplayName());
        target.setDescription(source.getDescription());
        return target;
    }

    private Channel toChannel(ChannelDO source) {
        if (source == null) {
            return null;
        }

        Channel target = new Channel();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setDefaultLanguageCode(source.getDefaultLanguageCode());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    private FoodNutrient toFoodNutrient(FoodNutrientDO foodNutrientDO) {
        FoodNutrient foodNutrient = toBaseFoodNutrient(foodNutrientDO);
        Long nutrientId = foodNutrient.getNutrientId();
        NutrientDO nutrientDO = nutrientManager.queryById(nutrientId);
        foodNutrient.setNutrient(toNutrient(nutrientDO));

        Long unitId = foodNutrient.getUnitId();
        UnitDO servingUnitDO = unitManager.queryById(unitId);
        Unit unit = toUnit(servingUnitDO);
        foodNutrient.setUnit(unit);
        return foodNutrient;
    }

    private Nutrient toNutrient(NutrientDO source) {
        if (source == null) {
            return null;
        }

        Nutrient target = new Nutrient();
        target.setId(source.getId());
        target.setChannelId(source.getChannelId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setDisplayName(source.getDisplayName());
        target.setAbbreviation(source.getAbbreviation());
        target.setOrder(source.getOrder());
        return target;
    }

    private FoodNutrient toBaseFoodNutrient(FoodNutrientDO source) {
        if (source == null) {
            return null;
        }

        FoodNutrient target = new FoodNutrient();
        target.setId(source.getId());
        target.setFoodId(source.getFoodId());
        target.setNutrientId(source.getNutrientId());
        target.setValue(source.getValue());
        target.setUnitId(source.getUnitId());
        return target;
    }

    private FoodBrand toFoodBrand(FoodBrandDO foodBrandDO) {
        FoodBrand foodBrand = toBaseFoodBrand(foodBrandDO);

        Long brandId = foodBrandDO.getBrandId();
        BrandDO brandDO = brandManager.queryById(brandId);
        Brand brand = toBaseBrand(brandDO);

        Long brandOwnerId = brandDO.getBrandOwnerId();
        BrandOwnerDO brandOwnerDO = brandOwnerManager.queryById(brandOwnerId);
        BrandOwner brandOwner = toBrandOwner(brandOwnerDO);
        brand.setBrandOwner(brandOwner);

        foodBrand.setBrand(brand);

        Long packageWeightUnitId = foodBrandDO.getPackageWeightUnitId();
        if (packageWeightUnitId != null && packageWeightUnitId > 0) {
            UnitDO servingUnitDO = unitManager.queryById(packageWeightUnitId);
            Unit unit = toUnit(servingUnitDO);
            foodBrand.setPackageWeightUnit(unit);
        }
        return foodBrand;
    }

    private BrandOwner toBrandOwner(BrandOwnerDO source) {
        if (source == null) {
            return null;
        }

        BrandOwner target = new BrandOwner();
        target.setId(source.getId());
        target.setChannelId(source.getChannelId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        return target;
    }

    private Brand toBaseBrand(BrandDO source) {
        if (source == null) {
            return null;
        }

        Brand target = new Brand();
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        return target;
    }

    private FoodBrand toBaseFoodBrand(FoodBrandDO source) {
        if (source == null) {
            return null;
        }

        FoodBrand target = new FoodBrand();
        target.setId(source.getId());
        target.setFoodId(source.getFoodId());
        target.setPackageWeight(source.getPackageWeight());
        target.setPackageServing(source.getPackageServing());
        target.setProductCode(source.getProductCode());
        return target;
    }

    private void setFoodIngredients(Food food, List<FoodIngredientDO> ingredientDOS, FoodIdQueryParam param) {
        List<FoodIngredient> foodIngredients = new ArrayList<>();
        for (FoodIngredientDO ingredientDO : ingredientDOS) {
            FoodIngredient foodIngredient = toFoodIngredient(ingredientDO);
            foodIngredient.setIngredientFood(queryById(param));

            foodIngredients.add(foodIngredient);
        }

        food.setFoodIngredients(foodIngredients);
    }

    private FoodIngredient toFoodIngredient(FoodIngredientDO source) {
        if (source == null) {
            return null;
        }

        FoodIngredient target = new FoodIngredient();
        target.setId(source.getId());
        target.setFoodId(source.getFoodId());
        target.setIngredientFoodId(source.getIngredientFoodId());
        return target;
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
