package me.cxis.fdc.dao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FoodDO {
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String creatorId;

    private String modifierId;

    private Boolean deleted;

    private Long channelId;

    private String code;

    private String name;

    private String description;

    private Long categoryId;

    private Long typeId;

    private String serving;

    private BigDecimal servingValue;

    private Long servingUnitId;

    private BigDecimal servingAmount;

    private String servingAmountUnitCode;

    private Long sourceId;

    private String sourceCode;

    private Boolean branded;

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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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

    public Long getServingUnitId() {
        return servingUnitId;
    }

    public void setServingUnitId(Long servingUnitId) {
        this.servingUnitId = servingUnitId;
    }

    public BigDecimal getServingAmount() {
        return servingAmount;
    }

    public void setServingAmount(BigDecimal servingAmount) {
        this.servingAmount = servingAmount;
    }

    public String getServingAmountUnitCode() {
        return servingAmountUnitCode;
    }

    public void setServingAmountUnitCode(String servingAmountUnitCode) {
        this.servingAmountUnitCode = servingAmountUnitCode;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
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
}