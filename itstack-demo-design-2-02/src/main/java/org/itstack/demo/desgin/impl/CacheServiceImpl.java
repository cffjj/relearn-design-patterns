package org.itstack.demo.desgin.impl;

import org.itstack.demo.desgin.CacheService;
import org.itstack.demo.design.RedisUtils;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtils = new RedisUtils();


    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeOut, TimeUnit timeUnit) {
        redisUtils.set(key,value,timeOut,timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }
}
