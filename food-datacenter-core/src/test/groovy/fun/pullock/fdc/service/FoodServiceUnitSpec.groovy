package fun.pullock.fdc.service


import spock.lang.Narrative
import spock.lang.Title

@Title("FoodService单元测试")
@Narrative("""
    FoodService单元测试。
""")
class FoodServiceUnitSpec extends fun.pullock.fdc.AbstractUnitSpec {

    def "test queryById"() {
        given: "FoodService"
        def foodService = new FoodService()
        def param = new fun.pullock.fdc.model.param.FoodIdQueryParam(
                id: 1L,
                channel: "test-channel",
                languageCode: "en"
        )

        and: "模拟ChannelManager"
        def channelManager = Mock(fun.pullock.fdc.manager.ChannelManager)
        foodService.channelManager = channelManager

        channelManager.queryByCode(_) >> null

        when: "调用queryById方法"
        def result = foodService.queryById(param)

        then: "验证返回结果"
        !result
    }
}
