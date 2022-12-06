package me.cxis.fdc.service

import jakarta.annotation.Resource
import me.cxis.fdc.AbstractIntegrationSpec
import me.cxis.fdc.AbstractUnitSpec
import me.cxis.fdc.manager.FoodManager
import spock.lang.Narrative
import spock.lang.Title

@Title("FoodService集成测试")
@Narrative("""
    FoodService集成测试。
""")
class FoodServiceIntegrationSpec extends AbstractIntegrationSpec {

    @Resource
    FoodService foodService

    def "test queryFoodName"() {
        given: "foodId"
        def foodId = 1L

        when: "调用queryFoodName方法"
        def result = foodService.queryFoodName(foodId)

        then: "验证返回结果"
        !result
    }
}
