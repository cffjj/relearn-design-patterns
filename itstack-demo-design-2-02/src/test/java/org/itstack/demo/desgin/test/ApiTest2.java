package org.itstack.demo.desgin.test;

import org.itstack.demo.mydesgin.CacheService;
import org.itstack.demo.mydesgin.factory.JDKProxy;
import org.itstack.demo.mydesgin.factory.impl.EGMCacheAdapter;
import org.itstack.demo.mydesgin.factory.impl.IIRCacheAdapter;
import org.itstack.demo.mydesgin.impl.CacheServiceImpl;
import org.junit.Test;

public class ApiTest2 {

    @Test
    public void test_CacheService(){
        CacheService proxy = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy.set("11","22");
        String s = proxy.get("11");
        System.out.println("测试结果："+s);


        CacheService proxy1 = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        String s1 = proxy1.get("11");
        System.out.println("测试结果：" + s1);

    }
}
