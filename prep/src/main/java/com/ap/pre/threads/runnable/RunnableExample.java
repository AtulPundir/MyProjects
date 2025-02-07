package com.ap.pre.threads.runnable;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        // Create an instance of MyRunnable
        MyRunnable task = new MyRunnable();

        // Create a Thread object and pass the Runnable instance
        Thread thread = new Thread(task);

        // Start the thread
        thread.start();

        // Main thread
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
