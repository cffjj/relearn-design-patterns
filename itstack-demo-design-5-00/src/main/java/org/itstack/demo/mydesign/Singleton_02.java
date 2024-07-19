package org.itstack.demo.mydesign;

public class Singleton_02 {
    private static Singleton_02 singleton02;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getSingleton02(){
        if (singleton02 != null) return singleton02;
        singleton02 = new Singleton_02();
        return singleton02;
    }
}
