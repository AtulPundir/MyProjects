package com.ap.pre.designpatterns.prototype;

class Car implements Cloneable{
    String model;
    String brand;

    Car(String model, String brand){
        this.model = model;
        this.brand = brand;
    }

    public Car clone() throws CloneNotSupportedException{
        return (Car)super.clone();
    }

    void print() {
        System.out.println(this.brand);
    }


}


public class ProtoTypeExample {
    public static void main(String[] args) throws CloneNotSupportedException{
        Car c = new Car ("S600", "Mercedez");
        //Car c2 = new Car ("DEFENDER", "RANGE ROVER");
        Car c2 = c.clone();

        c.print();
        c2.print();
        
    }

}
