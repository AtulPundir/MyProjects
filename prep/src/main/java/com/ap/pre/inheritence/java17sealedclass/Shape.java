package com.ap.pre.inheritence.java17sealedclass;

// Sealed class declaration
sealed abstract class Shape permits Circle, Rectangle, Triangle {
    abstract double area();
}

// Permitted subclasses
final class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

sealed class Rectangle extends Shape permits Rectangle2{
    double length, breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double area() {
        return length * breadth;
    }
}

final class Rectangle2 extends Rectangle {
    double length, breadth;

    Rectangle2(double length, double breadth) {
        super(length,breadth);
    }

    @Override
    double area() {
        return length * breadth;
    }
}

// Non-sealed subclass (can be further extended)
non-sealed class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

// Triangle subclass (allowed because Triangle is non-sealed)
class EquilateralTriangle extends Triangle {
    EquilateralTriangle(double side) {
        super(side, Math.sqrt(3) / 2 * side);
    }
}


