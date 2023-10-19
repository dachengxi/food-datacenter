package fun.pullock.fdc.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class FoodNutrient implements Serializable {

    @Serial
    private static final long serialVersionUID = 955268420829365905L;

    private Long id;

    private Long foodId;

    private Long nutrientId;

    private Nutrient nutrient;

    private BigDecimal value;

    private Long unitId;

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

    public Long getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(Long nutrientId) {
        this.nutrientId = nutrientId;
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

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
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
                ", nutrientId=" + nutrientId +
                ", nutrient=" + nutrient +
                ", value=" + value +
                ", unitId=" + unitId +
                ", unit=" + unit +
                '}';
    }
}
