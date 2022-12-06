package me.cxis.fdc.service

import me.cxis.fdc.AbstractUnitSpec
import me.cxis.fdc.manager.FoodManager
import spock.lang.Narrative
import spock.lang.Title

@Title("FoodService单元测试")
@Narrative("""
    FoodService单元测试。
""")
class FoodServiceUnitSpec extends AbstractUnitSpec {

    def "test add"() {
        given: "FoodService"
        def foodService = new FoodService()

        and: "模拟FoodManager"
        def foodManager = Mock(FoodManager)
        foodService.foodManager = foodManager

        foodManager.add() >> true

        when: "调用add方法"
        def result = foodService.add()

        then: "验证返回结果"
        result
    }
}
