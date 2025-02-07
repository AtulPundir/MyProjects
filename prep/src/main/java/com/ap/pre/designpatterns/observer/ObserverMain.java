package com.ap.pre.designpatterns.observer;

public class ObserverMain {

    public static void main(String[] args) {

        Observable subject = new Observable();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
    
    
        subject.addObserver(observer1);
        subject.addObserver(observer2);
    
        subject.setState("New State 1");
        subject.setState("New State 2");
        
    }

   

}
