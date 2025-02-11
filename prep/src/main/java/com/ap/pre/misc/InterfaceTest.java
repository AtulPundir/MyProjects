package com.ap.pre.misc;


interface TestInter{
    void myprint(String s);

    default void defaultMethod(){
        System.out.println("This is the DEFAULT method of interface.");
    }
    default void defaultMethod2(){
        defaultMethod();
        staticMethod();
        System.out.println("This is the DEFAULT2 method of interface.");
    }

    static void staticMethod(){
        staticMethod2();
        System.out.println("This is the STATIC  method of interface.");
    }
    static void staticMethod2(){
        System.out.println("This is the STATIC2 method of interface.");
    }


}

public class InterfaceTest implements TestInter{
    public static void main(String[] args) {
        InterfaceTest obj = new InterfaceTest();
        obj.defaultMethod();
        //obj.staticMethod();  //compiletime error //This static method of interface TestInter can only be accessed as TestInter.staticMethod
        InterfaceTest.staticMethod();

        System.out.println();
        obj.defaultMethod2();
        System.out.println();
        TestInter.staticMethod();

        
    }

    @Override
    public void myprint(String s) {
        System.out.println("This is overridden method in class");
    }

    static void staticMethod(){
        System.out.println("This is static method of class.");
    }
    
}
