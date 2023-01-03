package me.cxis.fdc.service

import me.cxis.fdc.AbstractUnitSpec
import me.cxis.fdc.manager.ChannelManager
import me.cxis.fdc.manager.FoodManager
import me.cxis.fdc.model.param.FoodIdQueryParam
import spock.lang.Narrative
import spock.lang.Title

@Title("FoodService单元测试")
@Narrative("""
    FoodService单元测试。
""")
class FoodServiceUnitSpec extends AbstractUnitSpec {

    def "test queryById"() {
        given: "FoodService"
        def foodService = new FoodService()
        def param = new FoodIdQueryParam(
                id: 1L,
                channel: "test-channel",
                languageCode: "en"
        )

        and: "模拟ChannelManager"
        def channelManager = Mock(ChannelManager)
        foodService.channelManager = channelManager

        channelManager.queryByCode(_) >> null

        when: "调用queryById方法"
        def result = foodService.queryById(param)

        then: "验证返回结果"
        !result
    }
}
