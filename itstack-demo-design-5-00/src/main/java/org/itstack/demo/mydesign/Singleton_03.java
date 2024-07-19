package org.itstack.demo.mydesign;

public class Singleton_03 {
    private static Singleton_03 singleton03 = new Singleton_03();

    private Singleton_03() {
    }

    public Singleton_03 getSingleton03(){
        return singleton03;
    }

}
