package org.itstack.demo.mydesgin.factory;



import org.itstack.demo.mydesgin.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method cacheMethod = ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args));

        return cacheMethod.invoke(cacheAdapter,args);
    }
}
