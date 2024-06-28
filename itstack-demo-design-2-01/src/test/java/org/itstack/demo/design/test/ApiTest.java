package org.itstack.demo.design.test;

import org.itstack.demo.design.CacheService;
import org.itstack.demo.design.cuisine.impl.CacheServiceImpl;
import org.junit.Test;

public class ApiTest {


    @Test
    public void test_CacheService(){
        CacheService cacheService = new CacheServiceImpl();
        cacheService.set("myname","caifujin",1);
        String val01 = cacheService.get("myname", 1);
        String val02 = cacheService.get("myname", 2);
        String val03 = cacheService.get("myname", 3);

        System.out.println("val01：" + val01 + "--"+"val02：" + val02 + "--"+"val03：" + val03);
    }
}
