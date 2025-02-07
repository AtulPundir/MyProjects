package com.ap.pre.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                System.out.println("Running task in virtual thread: " + Thread.currentThread());
                try {
                    Thread.sleep(1000); // Virtual thread "parks" instead of blocking an OS thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}
