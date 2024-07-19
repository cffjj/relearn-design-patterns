package org.itstack.demo.mydesign;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton_06 {
    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<>();
    private static Singleton_06 singleton06;

    private Singleton_06() {
    }

    public static final Singleton_06 getSingleton06(){
        for (;;){
            Singleton_06 instance = INSTANCE.get();
            if (instance != null) return instance;
            INSTANCE.compareAndSet(null,new Singleton_06());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton_06.getSingleton06());
        System.out.println(Singleton_06.getSingleton06());

    }
}
