package org.itstack.demo.design;

/**
 *
 * 双重检查锁定的实现有一个潜在的问题，即在某些版本的 Java 中，可能会出现指令重排序问题。指令重排序可能导致一个线程看到一个未完全初始化的实例。
 * 在 Java 5 及以上版本，双重检查锁定是安全的，因为 volatile 关键字可以防止指令重排序。使用 volatile 可以确保实例的正确初始化。
 */
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
