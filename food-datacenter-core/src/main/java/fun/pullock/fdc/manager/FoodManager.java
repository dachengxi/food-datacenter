package fun.pullock.fdc.manager;

import jakarta.annotation.Resource;
import fun.pullock.fdc.dao.mapper.FoodDOMapper;
import fun.pullock.fdc.dao.mapper.FoodLanguageDOMapper;
import fun.pullock.fdc.dao.model.FoodDO;
import fun.pullock.fdc.dao.model.FoodLanguageDO;
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
