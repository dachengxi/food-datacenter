package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.FoodDOMapper;
import me.cxis.fdc.dao.model.FoodDO;
import org.springframework.stereotype.Component;

@Component
public class FoodManager {

    @Resource
    private FoodDOMapper foodDOMapper;

    public boolean add() {
        return true;
    }

    public FoodDO queryById(Long id) {
        return foodDOMapper.selectByPrimaryKey(id);
    }
}
