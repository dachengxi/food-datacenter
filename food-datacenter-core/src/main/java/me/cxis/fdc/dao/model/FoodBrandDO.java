package me.cxis.fdc.dao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FoodBrandDO {
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String creatorId;

    private String modifierId;

    private Boolean deleted;

    private Long foodId;

    private Long brandId;

    private BigDecimal packageWeight;

    private Long packageWeightUnitId;

    private BigDecimal packageServing;

    private String productCode;

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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public BigDecimal getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(BigDecimal packageWeight) {
        this.packageWeight = packageWeight;
    }

    public Long getPackageWeightUnitId() {
        return packageWeightUnitId;
    }

    public void setPackageWeightUnitId(Long packageWeightUnitId) {
        this.packageWeightUnitId = packageWeightUnitId;
    }

    public BigDecimal getPackageServing() {
        return packageServing;
    }

    public void setPackageServing(BigDecimal packageServing) {
        this.packageServing = packageServing;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}