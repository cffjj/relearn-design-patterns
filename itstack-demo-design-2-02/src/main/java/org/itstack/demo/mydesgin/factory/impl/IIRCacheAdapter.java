package org.itstack.demo.mydesgin.factory.impl;

import org.itstack.demo.design.matter.IIR;
import org.itstack.demo.mydesgin.factory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

public class IIRCacheAdapter implements ICacheAdapter {
    private IIR iir = new IIR();
    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeOut, TimeUnit timeUnit) {
        iir.setExpire(key,value,timeOut,timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}
