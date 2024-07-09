package org.itstack.demo.design;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public class MQAdapter {
    public static RebateInfo filter(String json, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(json,Map.class), link);
    }


    public static RebateInfo filter(Map<String,Object> obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        RebateInfo rebateInfo = new RebateInfo();
        Set<String> keys = link.keySet();
        for (String key : keys) {
            Object val = obj.get(link.get(key));
            Method method = RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class);
            method.invoke(rebateInfo, val.toString());
        }
        return rebateInfo;


    }
}
