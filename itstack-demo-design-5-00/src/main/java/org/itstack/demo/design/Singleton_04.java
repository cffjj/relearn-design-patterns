package org.itstack.demo.design;

public class Singleton_04 {

    private static class SingletonHolder{
        private static Singleton_04 singleton04 = new Singleton_04();
    }

    private Singleton_04() {
    }

    public static Singleton_04 singleton04(){
        return SingletonHolder.singleton04;
    }
}
