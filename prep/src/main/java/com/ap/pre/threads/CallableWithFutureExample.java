package com.ap.pre.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithFutureExample {
    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            System.out.println("Task is running on thread: " + Thread.currentThread().getName());
            return 42;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable runnableTask = () -> {
            System.out.println("Runnable task is running on thread: " + Thread.currentThread().getName());
        };

        try {
            Future<Integer> future = executor.submit(task);

            Future<?> futureForRunnable = executor.submit(runnableTask);

            System.out.println("Result from My Callable: " + future);   // DOES NOT Wait for result
            System.out.println("Result from My Callable: " + future.get());     //Waits for result
            Integer result = future.get(); // Blocks until the result is available
            System.out.println("Result from Callable: " + result);

            Object result2 = futureForRunnable.get(); // Blocks until the result is available
            System.out.println("Result from Callable: " + result2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown(); // Shut down the executor
        }
    }
}
