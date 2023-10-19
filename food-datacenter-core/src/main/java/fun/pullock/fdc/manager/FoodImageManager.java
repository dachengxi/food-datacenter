package fun.pullock.fdc.manager;

import fun.pullock.fdc.dao.mapper.FoodImageDOMapper;
import fun.pullock.fdc.dao.model.FoodImageDO;
import jakarta.annotation.Resource;
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
