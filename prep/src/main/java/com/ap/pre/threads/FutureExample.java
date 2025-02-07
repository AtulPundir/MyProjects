package com.ap.pre.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            Thread.sleep(3000); // Simulate work
            return 10;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(task);


        try {
            // Check if the task is done
            if (!future.isDone()) {
                System.out.println("Task is still running...");
            }

            // Cancel the task (optional)
            // future.cancel(true);

            // Wait and get the result
            Integer result = future.get();
            System.out.println("Task completed with result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
