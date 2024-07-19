package org.itstack.demo.mydesgin.factory.impl;

import org.itstack.demo.design.matter.EGM;
import org.itstack.demo.mydesgin.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

public class EGMCacheAdapter implements ICacheAdapter {
    private EGM egm = new EGM();
    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeOut, TimeUnit timeUnit) {
        egm.setEx(key,value,timeOut,timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
