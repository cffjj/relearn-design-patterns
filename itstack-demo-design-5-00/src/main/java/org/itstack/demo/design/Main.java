package org.itstack.demo.design;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();

        Field name = person.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(person,"李四");

        System.out.println(person.getName());


    }
}
