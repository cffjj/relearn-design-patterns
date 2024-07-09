package org.itstack.demo.design.test;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.AuthController;
import org.itstack.demo.design.AuthService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

public class ApiTest {

    public static final String NUMBER = "1000998004813441";
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_AuthController() throws ParseException {
        AuthController authController = new AuthController();

        //模拟三级负责人审批
        logger.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小菜",NUMBER,new Date())));
        logger.info("测试结果：{}", "模拟三级负责人审批，小菜");
        AuthService.auth("1000013",NUMBER);

        //模拟二级负责人审批
        logger.info("测试结果：{}", JSON.toJSONString(authController.doAuth("中菜",NUMBER,new Date())));
        logger.info("测试结果：{}", "模拟二级负责人审批，中菜");
        AuthService.auth("1000012",NUMBER);

        // 模拟一级负责人审批
        logger.info("测试结果：{}", JSON.toJSONString(authController.doAuth("大菜", NUMBER, new Date())));
        logger.info("测试结果：{}", "模拟一级负责人审批，大菜");
        AuthService.auth("1000011", NUMBER);

        logger.info("测试结果：{}", "审批完成");

    }
}
