package org.itstack.demo.design.test;

import org.itstack.demo.design.impl.JDNetMall;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_NetMall(){
        JDNetMall jdNetMall = new JDNetMall("1000001", "*******");
        String base64 = jdNetMall.generateGoodsPoster("https://item.jd.com/10104046748627.html");
        logger.info("测试结果：{}",base64);
    }
}
