package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.FoodIngredientDOMapper;
import fun.pullock.fdc.dao.model.FoodIngredientDO;
import jakarta.annotation.Resource;
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
