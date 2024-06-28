package org.itstack.demo.desgin.test;

import org.itstack.demo.desgin.CacheService;
import org.itstack.demo.desgin.factory.JDKProxy;
import org.itstack.demo.desgin.factory.impl.EGMCacheAdapter;
import org.itstack.demo.desgin.factory.impl.IIRCacheAdapter;
import org.itstack.demo.desgin.impl.CacheServiceImpl;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_CacheService(){
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("username","cai");
        String s1 = proxy_EGM.get("username");
        System.out.println("测试结果：" + s1);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("username","caicai");
        String s2 = proxy_IIR.get("username");
        System.out.println("测试结果：" + s2);

    }
}
