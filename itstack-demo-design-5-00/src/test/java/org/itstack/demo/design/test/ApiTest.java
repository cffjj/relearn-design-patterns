package org.itstack.demo.design.test;

import org.itstack.demo.design.Singleton_07;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test(){
        Singleton_07.INSTANCE.test();
        org.itstack.demo.mydesign.Singleton_07.INSTANCE.test();
    }
}
