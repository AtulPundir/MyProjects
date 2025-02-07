package com.ap.pre.inheritence;

//if the parent class does not have a no-argument constructor, you must explicitly call it from the child class. Otherwise, the code will not compile.
class Parent {

    Parent(int i){
        System.out.println(i);
    }
}

class Child extends Parent {

    Child(int i){
        super(i);       //If not called, then its a compile time error
        System.out.println(i);
    }
}
class Parent2 {

    Parent2(){}

    Parent2(int i){
        System.out.println(i);
    }
}

class Child2 extends Parent2 {

    Child2 (int i){
        System.out.println(i);
    }
}
public class DeclaredContructorInInheritence {

    public static void main(String[] args) {
        Parent p = new Parent(1);
        System.out.println("++++++++++++++++++++");
        Child c = new Child(2);
        System.out.println("++++++++++++++++++++");
        Parent p2 = new Child(3); 
    }
    

}

