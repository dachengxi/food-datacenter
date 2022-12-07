package me.cxis.fdc.model;

import java.io.Serial;
import java.io.Serializable;

public class FoodIngredient implements Serializable {

    @Serial
    private static final long serialVersionUID = 4690388743577920053L;

    private Long id;

    private Long foodId;

    private Long ingredientFoodId;

    private Food ingredientFood;

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

    public Long getIngredientFoodId() {
        return ingredientFoodId;
    }

    public void setIngredientFoodId(Long ingredientFoodId) {
        this.ingredientFoodId = ingredientFoodId;
    }

    public Food getIngredientFood() {
        return ingredientFood;
    }

    public void setIngredientFood(Food ingredientFood) {
        this.ingredientFood = ingredientFood;
    }

    @Override
    public String toString() {
        return "FoodIngredient{" +
                "id=" + id +
                ", foodId=" + foodId +
                ", ingredientFoodId=" + ingredientFoodId +
                ", ingredientFood=" + ingredientFood +
                '}';
    }
}
