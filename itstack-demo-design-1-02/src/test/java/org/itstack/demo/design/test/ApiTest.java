package org.itstack.demo.design.test;

import org.itstack.demo.design.StoreFactory;
import org.itstack.demo.design.store.ICommodity;
import org.junit.Test;

import java.util.HashMap;

public class ApiTest {

    @Test
    public void test_commodity() throws Exception {

        StoreFactory storeFactory = new StoreFactory();
        ICommodity commodityService1 = storeFactory.getCommodityService(1);
        commodityService1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);


        commodityService1 = storeFactory.getCommodityService(2);
        commodityService1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132",new HashMap<String,String>(){{
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");}});

        commodityService1 = storeFactory.getCommodityService(3);
        commodityService1.sendCommodity("10001", "EGM1023938910232121323432", null,null);

    }
}
