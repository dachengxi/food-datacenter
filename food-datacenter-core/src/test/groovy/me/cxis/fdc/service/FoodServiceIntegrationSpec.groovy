package me.cxis.fdc.service

import jakarta.annotation.Resource
import me.cxis.fdc.AbstractIntegrationSpec
import me.cxis.fdc.AbstractUnitSpec
import me.cxis.fdc.manager.FoodManager
import me.cxis.fdc.model.param.FoodIdQueryParam
import spock.lang.Narrative
import spock.lang.Title

@Title("FoodService集成测试")
@Narrative("""
    FoodService集成测试。
""")
class FoodServiceIntegrationSpec extends AbstractIntegrationSpec {

    @Resource
    FoodService foodService

    def "test queryById"() {
        given: "foodId"
        def foodId = 1L
        def param = new FoodIdQueryParam(
                id: foodId,
                channel: "test-channel",
                languageCode: "en"
        )

        when: "调用queryById方法"
        def result = foodService.queryById(param)

        then: "验证返回结果"
        !result
    }
}
