package org.itstack.demo.design.test;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.designfj.LotteryResult;
import org.itstack.demo.designfj.LotteryService;
import org.itstack.demo.designfj.LotteryServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109875");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }

}
