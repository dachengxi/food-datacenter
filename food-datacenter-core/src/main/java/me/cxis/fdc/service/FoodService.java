package me.cxis.fdc.service;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.model.FoodDO;
import me.cxis.fdc.manager.FoodManager;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Resource
    private FoodManager foodManager;

    public boolean add() {
        return foodManager.add();
    }

    public String queryFoodName(Long id) {
        FoodDO foodDO = foodManager.queryById(id);
        if (foodDO == null) {
            return null;
        }

        return foodDO.getName();
    }
}
