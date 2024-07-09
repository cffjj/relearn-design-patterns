package org.itstack.demo.design;

public class Singleton_01 {

    private static Singleton_01 singleton01;

    private Singleton_01() {
    }

    public static Singleton_01 getSingleton(){
        if (singleton01 != null) return singleton01;
        singleton01 = new Singleton_01();
        return singleton01;
    }
}
