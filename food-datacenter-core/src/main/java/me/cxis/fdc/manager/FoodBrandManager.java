package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.FoodBrandDOMapper;
import me.cxis.fdc.dao.model.FoodBrandDO;
import org.springframework.stereotype.Component;

@Component
public class FoodBrandManager {

    @Resource
    private FoodBrandDOMapper foodBrandDOMapper;

    public FoodBrandDO queryByFoodId(Long foodId) {
        return foodBrandDOMapper.selectByFoodId(foodId);
    }
}
