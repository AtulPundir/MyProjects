package com.ap.pre.inheritence;

class A
{
    void m1() throws ArrayIndexOutOfBoundsException
    {
        System.out.println("In m1 A");
    }
}
class B extends A
{
    void m1() throws IndexOutOfBoundsException
    {
        System.out.println("In m1 B");
    }
}
public class Test {
 
    public static void main(String[] args) {
        A a=new B();
        a.m1();
    }
}