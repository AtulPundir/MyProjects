package com.ap.pre.designpatterns.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    private static Singleton obj;  //Lazy initialization
    //private Singleton obj = new Singleton();      //Eager initialization
    //private static volatile Singleton object;     //ThreadSafe

    private Singleton(){
        if(obj != null){
            //throw new RuntimeException("You are trying to break Singleton");  //Avoiding reflection break
        }
    }


    public static Singleton getObject(){
   // public static synchronized  Singleton getObject(){    //Method synchronization, will block all the code in method, threads will wait to execute all in it

        if(obj == null){
            synchronized (Singleton.class) {
                
                 obj = new Singleton();
                
            }
            
        }
        return obj;
    }

    protected Object readResolve() throws ObjectStreamException {
        return obj;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
       //return super.clone();   //Breaks Singleton
        return obj;
    }

    

}
