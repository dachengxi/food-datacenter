package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.FoodIngredientDOMapper;
import me.cxis.fdc.dao.model.FoodIngredientDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodIngredientManager {

    @Resource
    private FoodIngredientDOMapper foodIngredientDOMapper;

    public List<FoodIngredientDO> queryByFoodId(Long foodId) {
        return foodIngredientDOMapper.selectByFoodId(foodId);
    }
}
