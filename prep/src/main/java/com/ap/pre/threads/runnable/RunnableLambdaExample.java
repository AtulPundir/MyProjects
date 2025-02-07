package com.ap.pre.threads.runnable;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        // Using a lambda expression
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running: " + Thread.currentThread().getName());
        });

        thread.start();


        new Thread(() -> {
            System.out.println("Thread2 is running: " + Thread.currentThread().getName());
        }).start();;
    }
}
