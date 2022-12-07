package me.cxis.fdc.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class FoodNutrient implements Serializable {

    @Serial
    private static final long serialVersionUID = 955268420829365905L;

    private Long id;

    private Long foodId;

    private Nutrient nutrient;

    private BigDecimal value;

    private Unit unit;

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

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "FoodNutrient{" +
                "id=" + id +
                ", foodId=" + foodId +
                ", nutrient=" + nutrient +
                ", value=" + value +
                ", unit=" + unit +
                '}';
    }
}
