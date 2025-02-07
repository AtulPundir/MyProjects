package com.ap.pre.designpatterns.singleton;

import java.util.concurrent.Semaphore;

public class SingletonWithSemaphore {

    private static final Semaphore semaphore = new Semaphore(5);

    private static SingletonWithSemaphore object;

    private SingletonWithSemaphore() {

    }

    public static SingletonWithSemaphore getObject() {

        if (object == null) {
            synchronized (SingletonWithSemaphore.class) {
                if (object == null) {
                    object = new SingletonWithSemaphore();
                }
            }

        }
        return object;
    }

    public void executeTask() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is executing.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

    public class SingletonWithSemaphoreTest {

        public static void main(String[] args) {
            Runnable task = () -> {
            SingletonWithSemaphore obj = SingletonWithSemaphore.getObject();
            obj.executeTask();
        };

        // Creating 10 threads to simulate concurrent access
        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }
        }

    }
}
