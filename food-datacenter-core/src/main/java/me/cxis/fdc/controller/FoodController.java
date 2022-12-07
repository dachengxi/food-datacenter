package me.cxis.fdc.controller;

import jakarta.annotation.Resource;
import me.cxis.fdc.model.Food;
import me.cxis.fdc.model.param.FoodIdQueryParam;
import me.cxis.fdc.service.FoodService;
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
