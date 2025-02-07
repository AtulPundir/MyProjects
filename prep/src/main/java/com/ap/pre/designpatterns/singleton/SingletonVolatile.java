//How do you implement a thread-safe singleton class

package com.ap.pre.designpatterns.singleton;

public class SingletonVolatile {
    private static volatile SingletonVolatile instance;

    private SingletonVolatile() {}

    public static SingletonVolatile getInstance() {
        if (instance == null) {
            synchronized (SingletonVolatile.class) {
                if (instance == null) {
                    instance = new SingletonVolatile();
                }
            }
        }
        return instance;
    }
}