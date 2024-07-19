package org.itstack.demo.mydesign;

public class Singleton_01 {
    private static Singleton_01 singleton01;

    private Singleton_01() {
    }

    public Singleton_01 getSingleton01(){
        if (singleton01 != null) return singleton01;
        singleton01 = new Singleton_01();
        return singleton01;
    }
}
