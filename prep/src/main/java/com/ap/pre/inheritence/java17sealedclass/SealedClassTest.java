package com.ap.pre.inheritence.java17sealedclass;

public class SealedClassTest {

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4);
        Shape equilateralTriangle = new EquilateralTriangle(6);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Equilateral Triangle Area: " + equilateralTriangle.area());
    }
}
