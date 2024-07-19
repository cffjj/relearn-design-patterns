package org.itstack.demo.mydesgin.factory;

import java.lang.reflect.Proxy;

public class JDKProxy {

     public static <T> T getProxy(Class<T> interfaceClass,ICacheAdapter cacheAdapter){
        JDKInvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader =Thread.currentThread().getContextClassLoader();

        Class<?>[] interfaces = interfaceClass.getInterfaces();

        return (T) Proxy.newProxyInstance(classLoader,new Class[]{interfaces[0]},handler);


    }
}
