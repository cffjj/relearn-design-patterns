package org.itstack.demo.mydesign;

public class Singleton_04 {

    private static class SingletonHolder {
        private static Singleton_04 singleton04 = new Singleton_04();
    }
    public Singleton_04 getSingleton04(){
        return SingletonHolder.singleton04;
    }
}
