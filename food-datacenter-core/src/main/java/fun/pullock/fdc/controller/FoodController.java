package fun.pullock.fdc.controller;

import fun.pullock.fdc.model.Food;
import fun.pullock.fdc.model.param.FoodIdQueryParam;
import fun.pullock.fdc.service.FoodService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Resource
    private FoodService foodService;

    @GetMapping("/queryById")
    public Food queryById(@RequestBody FoodIdQueryParam param) {
        // TODO 校验参数
        return foodService.queryById(param);
    }
}
