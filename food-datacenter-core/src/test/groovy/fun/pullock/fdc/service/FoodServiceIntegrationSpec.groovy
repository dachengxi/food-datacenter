package fun.pullock.fdc.service


import jakarta.annotation.Resource
import spock.lang.Narrative
import spock.lang.Title

@Title("FoodService集成测试")
@Narrative("""
    FoodService集成测试。
""")
class FoodServiceIntegrationSpec extends fun.pullock.fdc.AbstractIntegrationSpec {

    @Resource
    FoodService foodService

    def "test queryById"() {
        given: "foodId"
        def foodId = 1L
        def param = new fun.pullock.fdc.model.param.FoodIdQueryParam(
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
