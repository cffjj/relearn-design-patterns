package org.itstack.demo.design.test;

import org.itstack.demo.design.EngineController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    Logger logger = LoggerFactory.getLogger(ApiTest.class);


    @Test
    public void test_EngineController() {
        EngineController engineController = new EngineController();
        String process = engineController.process("100001", "man", 24);
        logger.info("测试结果：{}", process);
    }
}
