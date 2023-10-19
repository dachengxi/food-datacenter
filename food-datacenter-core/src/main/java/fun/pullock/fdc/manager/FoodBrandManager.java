package fun.pullock.fdc.manager;

import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.mapper.FoodBrandDOMapper;
import fun.pullock.fdc.dao.model.FoodBrandDO;
import org.springframework.stereotype.Component;

@Component
public class FoodBrandManager {

    @Resource
    private FoodBrandDOMapper foodBrandDOMapper;

    public FoodBrandDO queryByFoodId(Long foodId) {
        return foodBrandDOMapper.selectByFoodId(foodId);
    }
}
