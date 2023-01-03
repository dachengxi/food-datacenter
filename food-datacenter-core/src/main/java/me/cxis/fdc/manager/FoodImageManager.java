package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.FoodImageDOMapper;
import me.cxis.fdc.dao.model.FoodImageDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodImageManager {

    @Resource
    private FoodImageDOMapper foodImageDOMapper;

    public List<FoodImageDO> queryByFoodId(Long foodId) {
        return foodImageDOMapper.selectByFoodId(foodId);
    }
}
