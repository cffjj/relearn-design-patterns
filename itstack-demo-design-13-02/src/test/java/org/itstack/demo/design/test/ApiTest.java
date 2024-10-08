package org.itstack.demo.design.test;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.AuthService;
import org.itstack.demo.mydesign.AuthLink;
import org.itstack.demo.mydesign.cuisine.impl.Level1AuthLink;
import org.itstack.demo.mydesign.cuisine.impl.Level2AuthLink;
import org.itstack.demo.mydesign.cuisine.impl.Level3AuthLink;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_AuthLink() throws ParseException {

        AuthLink authLink = new Level3AuthLink("1000013", "小菜")
                .appendNext(new Level2AuthLink("1000012", "中菜").appendNext(new Level1AuthLink("1000011", "大菜")));
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小菜","1000998004813441",new Date())));

        //模拟三级负责人审批
        AuthService.auth("1000013","1000998004813441");
        logger.info("测试结果：{}", "模拟三级负责人审批，小菜");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小菜", "1000998004813441", new Date())));

        //模拟二级负责人审批
        AuthService.auth("1000012","1000998004813441");
        logger.info("测试结果：{}", "模拟二级负责人审批，中菜");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("中菜", "1000998004813441", new Date())));

        //模拟一级负责人审批
        AuthService.auth("1000011","1000998004813441");
        logger.info("测试结果：{}", "模拟一级负责人审批，大菜");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("大菜", "1000998004813441", new Date())));
    }
}
