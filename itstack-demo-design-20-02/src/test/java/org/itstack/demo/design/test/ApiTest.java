package org.itstack.demo.design.test;

import org.itstack.demo.design.Context;
import org.itstack.demo.design.impl.MJCouponDiscount;
import org.itstack.demo.design.impl.NYGCouponDiscount;
import org.itstack.demo.design.impl.ZJCouponDiscount;
import org.itstack.demo.design.impl.ZKCouponDiscount;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_zj(){
        Context<Double> context = new Context<Double>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        logger.info("测试结果：直减优惠后金额 {}",discountAmount);
    }

    @Test
    public void test_mj(){
        Context<Map<String,String>> context = new Context<>(new MJCouponDiscount());
        HashMap<String, String> mapReq = new HashMap<>();
        mapReq.put("x","100");
        mapReq.put("n","10");
        BigDecimal discountAmount = context.discountAmount(mapReq,new BigDecimal(100));
        logger.info("测试结果：满减优惠后金额 {}",discountAmount);
    }

    @Test
    public void test_zk(){
        Context<Double> context = new Context<Double>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        logger.info("测试结果：折扣9折后金额 {}",discountAmount);
    }

    @Test
    public void test_nyg(){
        Context<Double> context = new Context<Double>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
        logger.info("测试结果：n元购优惠后金额 {}",discountAmount);
    }
}
