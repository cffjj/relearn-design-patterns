package org.itstack.demo.design.cuisine.impl;

import org.itstack.demo.design.CacheService;
import org.itstack.demo.design.RedisUtils;
import org.itstack.demo.design.matter.EGM;
import org.itstack.demo.design.matter.IIR;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl implements CacheService {

    RedisUtils redisUtils = new RedisUtils();

    private EGM egm = new EGM();

    private IIR iir = new IIR();
    @Override
    public String get(String key, int redisType) {
        if (1 == redisType){
            return egm.gain(key);
        }
        if (2 == redisType){
            return iir.get(key);
        }
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value, int redisType) {
        if (1 == redisType){
            egm.set(key,value);
            return;
        }
        if (2 == redisType){
            iir.set(key,value);
            return;
        }
        redisUtils.set(key,value);

    }

    @Override
    public void set(String key, String value, long timeOut, TimeUnit timeUnit, int redisType) {
        if (1 == redisType){
            egm.setEx(key,value,timeOut,timeUnit);
        }
        if (2 == redisType){
            iir.setExpire(key,value,timeOut,timeUnit);
        }else{
            redisUtils.set(key,value,timeOut,timeUnit);
        }
    }

    @Override
    public void del(String key, int redisType) {
        if (1 == redisType) {
            egm.delete(key);
            return;
        }
        if (2 == redisType) {
            iir.del(key);
            return;
        }
        redisUtils.del(key);
    }
}
