package me.cxis.fdc.manager;

import jakarta.annotation.Resource;
import me.cxis.fdc.dao.mapper.FoodDOMapper;
import me.cxis.fdc.dao.mapper.FoodLanguageDOMapper;
import me.cxis.fdc.dao.model.FoodDO;
import me.cxis.fdc.dao.model.FoodLanguageDO;
import org.springframework.stereotype.Component;

@Component
public class FoodManager {

    @Resource
    private FoodDOMapper foodDOMapper;

    @Resource
    private FoodLanguageDOMapper foodLanguageDOMapper;

    public boolean add() {
        return true;
    }

    public FoodDO queryById(Long id) {
        return foodDOMapper.selectByPrimaryKey(id);
    }

    public FoodLanguageDO queryLanguage(Long foodId, String languageCode) {
        return foodLanguageDOMapper.selectByFoodIdAndLanguageCode(foodId, languageCode);
    }
}
