package org.itstack.demo.design.fj.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyMapperFactoryBean<T> implements FactoryBean<T> {

    Logger logger = LoggerFactory.getLogger(MyMapperFactoryBean.class);

    private Class<T> mapperInterface;

    public MyMapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Update update = method.getAnnotation(Update.class);
            logger.info("SQL：{}", update.value().replace("#{uId}", args[0].toString()));
            return args[0] + "update";
        };

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{mapperInterface},handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
