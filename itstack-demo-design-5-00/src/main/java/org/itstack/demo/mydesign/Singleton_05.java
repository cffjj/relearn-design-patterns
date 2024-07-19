package org.itstack.demo.mydesign;

public class Singleton_05 {

    private static volatile Singleton_05 singleton05;

    private Singleton_05() {
    }

    public Singleton_05 getSingleton05(){
        if (null != singleton05) return singleton05;
        synchronized (Singleton_05.class){
            if (null == singleton05) {
                singleton05 = new Singleton_05();
            }
        }
        return singleton05;
    }
}
