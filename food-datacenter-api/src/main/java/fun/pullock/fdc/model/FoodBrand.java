package fun.pullock.fdc.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class FoodBrand implements Serializable {

    @Serial
    private static final long serialVersionUID = 2578699457171543417L;

    private Long id;

    private Long foodId;

    private Brand brand;

    private BigDecimal packageWeight;

    private Unit packageWeightUnit;

    private BigDecimal packageServing;

    private String productCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public BigDecimal getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(BigDecimal packageWeight) {
        this.packageWeight = packageWeight;
    }

    public Unit getPackageWeightUnit() {
        return packageWeightUnit;
    }

    public void setPackageWeightUnit(Unit packageWeightUnit) {
        this.packageWeightUnit = packageWeightUnit;
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

    @Override
    public String toString() {
        return "FoodBrand{" +
                "id=" + id +
                ", foodId=" + foodId +
                ", brand=" + brand +
                ", packageWeight=" + packageWeight +
                ", packageWeightUnit=" + packageWeightUnit +
                ", packageServing=" + packageServing +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
