package me.cxis.fdc.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Food implements Serializable {

    @Serial
    private static final long serialVersionUID = 24491581507346453L;

    private Long id;

    private Channel channel;

    private String code;

    private String name;

    private String description;

    private Category category;

    private Integer type;

    private String serving;

    private BigDecimal servingValue;

    private Unit servingUnit;

    private BigDecimal servingAmount;

    private Unit servingAmountUnit;

    private Source source;

    private String sourceCode;

    private Boolean branded;

    private List<FoodImage> foodImages;

    private List<FoodIngredient> foodIngredients;

    private FoodBrand foodBrand;

    private Language language;

    private List<FoodNutrient> foodNutrients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getServing() {
        return serving;
    }

    public void setServing(String serving) {
        this.serving = serving;
    }

    public BigDecimal getServingValue() {
        return servingValue;
    }

    public void setServingValue(BigDecimal servingValue) {
        this.servingValue = servingValue;
    }

    public Unit getServingUnit() {
        return servingUnit;
    }

    public void setServingUnit(Unit servingUnit) {
        this.servingUnit = servingUnit;
    }

    public BigDecimal getServingAmount() {
        return servingAmount;
    }

    public void setServingAmount(BigDecimal servingAmount) {
        this.servingAmount = servingAmount;
    }

    public Unit getServingAmountUnit() {
        return servingAmountUnit;
    }

    public void setServingAmountUnit(Unit servingAmountUnit) {
        this.servingAmountUnit = servingAmountUnit;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Boolean getBranded() {
        return branded;
    }

    public void setBranded(Boolean branded) {
        this.branded = branded;
    }

    public List<FoodImage> getFoodImages() {
        return foodImages;
    }

    public void setFoodImages(List<FoodImage> foodImages) {
        this.foodImages = foodImages;
    }

    public List<FoodIngredient> getFoodIngredients() {
        return foodIngredients;
    }

    public void setFoodIngredients(List<FoodIngredient> foodIngredients) {
        this.foodIngredients = foodIngredients;
    }

    public FoodBrand getFoodBrand() {
        return foodBrand;
    }

    public void setFoodBrand(FoodBrand foodBrand) {
        this.foodBrand = foodBrand;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<FoodNutrient> getFoodNutrients() {
        return foodNutrients;
    }

    public void setFoodNutrients(List<FoodNutrient> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", channel=" + channel +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", type=" + type +
                ", serving='" + serving + '\'' +
                ", servingValue=" + servingValue +
                ", servingUnit=" + servingUnit +
                ", servingAmount=" + servingAmount +
                ", servingAmountUnit=" + servingAmountUnit +
                ", source=" + source +
                ", sourceCode='" + sourceCode + '\'' +
                ", branded=" + branded +
                ", foodImages=" + foodImages +
                ", foodIngredients=" + foodIngredients +
                ", foodBrand=" + foodBrand +
                ", language=" + language +
                ", foodNutrients=" + foodNutrients +
                '}';
    }
}
