package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.FoodNutrientDOMapper;
import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.model.FoodNutrientDO;
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
