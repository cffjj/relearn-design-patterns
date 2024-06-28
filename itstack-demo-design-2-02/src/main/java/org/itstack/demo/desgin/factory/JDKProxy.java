package org.itstack.demo.desgin.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass,ICacheAdapter cacheAdapter){
        // 创建一个 InvocationHandler 实例，它将处理代理对象上的方法调用
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        // 获取当前线程的上下文类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 获取接口类的直接超接口数组，通常只有一个接口
        Class<?>[] classes = interfaceClass.getInterfaces();
        // 使用 Proxy.newProxyInstance 方法创建代理对象
        return (T) Proxy.newProxyInstance(classLoader,new Class[]{classes[0]},handler);

    }
}
