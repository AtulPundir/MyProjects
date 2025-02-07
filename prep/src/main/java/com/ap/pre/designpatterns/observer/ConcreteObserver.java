package com.ap.pre.designpatterns.observer;

public class ConcreteObserver implements Observer{
    private String name ;
    
    ConcreteObserver(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }

}
