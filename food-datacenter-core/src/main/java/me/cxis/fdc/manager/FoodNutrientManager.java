package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.FoodNutrientDOMapper;
import me.cxis.fdc.dao.model.FoodNutrientDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodNutrientManager {

    @Resource
    private FoodNutrientDOMapper foodNutrientDOMapper;

    public List<FoodNutrientDO> queryByFoodId(Long foodId) {
        return foodNutrientDOMapper.selectByFoodId(foodId);
    }
}
