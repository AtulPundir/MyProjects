package com.ap.pre.designpatterns.builder;

public class Car {

    private final String brand;
    private final String type;
    private final String model;
    private final String color;

    private Car(CarBuilder builder){

        this.brand = builder.brand;
        this.type = builder.type;
        this.model = builder.model;
        this.color = builder.color;


    }

    public static class CarBuilder{
        private final String brand; // Required field
        private String type;       // Optional field
        private String model;      // Optional field
        private  String color;     // Optional field

        public CarBuilder(String brand) {
            this.brand = brand;
        }

        public CarBuilder setType(String type){
            this.type = type;
            return this;
        }

        public CarBuilder setModel(String model){
            this.model = model;
            return this;
        }

        public CarBuilder setColor(String color){
            this.color = color;
            return this;
        }

        
        public Car build(){
            return new Car(this);
        }

    }

    @Override
    public String toString() {
        return "Car [Model=" + model + ", Color=" + color + ", Type=" + type + ", brand=" + brand + "]";
    }

    public static void main(String[] args) {
       
        Car car1 = new Car.CarBuilder("Range Rover")
                        .setColor("Black")
                        .setType("SUV")
                        .setModel("Vogue")
                        .build();

        Car car2 = new Car.CarBuilder("Range Rover")
                        .setColor("White")
                        .setType("SUV")
                        .setModel("Vogue")
                        .build();

        System.out.println(car1);
        System.out.println(car2);
    }

}
