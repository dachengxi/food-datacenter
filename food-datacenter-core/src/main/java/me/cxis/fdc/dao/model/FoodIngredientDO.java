package me.cxis.fdc.dao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FoodIngredientDO {
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String creatorId;

    private String modifierId;

    private Boolean deleted;

    private Long foodId;

    private Long ingredientFoodId;

    private String serving;

    private BigDecimal servingValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Long getIngredientFoodId() {
        return ingredientFoodId;
    }

    public void setIngredientFoodId(Long ingredientFoodId) {
        this.ingredientFoodId = ingredientFoodId;
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
}