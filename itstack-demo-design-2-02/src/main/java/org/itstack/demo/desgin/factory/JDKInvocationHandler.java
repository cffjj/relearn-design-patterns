package org.itstack.demo.desgin.factory;

import org.itstack.demo.desgin.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里可以添加一些逻辑，比如调用前后的处理
        // 例如，这里简单地将方法调用转发给 cacheAdapter 实例
        // 获取 ICacheAdapter 接口中的方法
        Method cacheMethod = ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args));
        // 调用 cacheAdapter 的方法，并传递参数
        return cacheMethod.invoke(cacheAdapter,args);
    }
}
