package com.ap.pre.reflection;

import java.lang.reflect.Method;

interface testinterface{
    void print();
}

class Parent implements testinterface{
    public void print(){
            System.out.println("Parent Method 1");
        }
    void print2(){
        System.out.println("Parent Method 2");
    }
}

class Child extends Parent {
    
    public void printC1(){
        System.out.println("Child Method 1");
    }
    void print2(){
        System.out.println("Child Method 2");
    }
    void print3(){
        System.out.println("Child Method 3");
    }
}

public class ReflectionTest {
    private final String privateString = "This is a private String";
    public static void main(String[] args) {
        Child c = new Child();

        Class clazz = c.getClass();
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getClassLoader().getName());
        System.out.println(clazz.getClassLoader().getClass().getName());

        System.out.println();
        System.out.println(clazz.getSuperclass().getName());

        Method methods []= clazz.getSuperclass().getDeclaredMethods();
        System.out.println();
        for(Method m : methods){
            System.out.println("METHOD");
            System.out.println(m.getName());
            System.out.println(m.getParameterTypes().getClass().getName());
            System.out.println(m.getDeclaringClass());
            System.out.println(m.getReturnType());
            System.out.println();

        }
        
    }

    
    
}
