package com.ap.pre.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.ap.pre.designpatterns.singleton.Singleton;

public class ReflectionMain {

   public static void main(String[] args) {

    try {
        Class<?> clazz = Class.forName("com.ap.pre.reflection.ReflectionTest");
        System.out.println("Created clazz");
        Field field = clazz.getDeclaredField("privateString");
        field.setAccessible(true);
        System.out.println(field.getName());

        String res = field.get(new ReflectionTest()).toString();
        
        System.out.println(res);
    
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton obj = constructor.newInstance();
        Singleton obj1 = constructor.newInstance();
        
    } catch (Exception e) {
       e.getMessage();
    }
   

    
   

   }
}
