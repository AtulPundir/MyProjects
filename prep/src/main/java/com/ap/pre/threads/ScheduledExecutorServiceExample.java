package com.ap.pre.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        //Runs after a 2-second delay
        Runnable task1 = () -> System.out.println("Task 1 by "+ Thread.currentThread().getName() +" executed at: " + System.currentTimeMillis());
        scheduler.schedule(task1, 2, TimeUnit.SECONDS);             //This will start after initial delay of 2 seconds
        //scheduler.scheduleAtFixedRate(task1, 0, 3, TimeUnit.SECONDS);   //This will start after immediately

        //Runs periodically every 3 seconds, starting after an initial delay of 1 second
        Runnable task2 = () -> System.out.println("Task 2 by "+ Thread.currentThread().getName() +" executed at: " + System.currentTimeMillis());
        scheduler.scheduleAtFixedRate(task2, 1, 3, TimeUnit.SECONDS);

        //Runs periodically with a 4-second delay between the end of the last execution and the start of the next
        Runnable task3 = () -> {
            System.out.println("Task 3 by "+ Thread.currentThread().getName() +" executed at: " + System.currentTimeMillis());
            try {
                Thread.sleep(2000); // Simulate a 2-second task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        scheduler.scheduleWithFixedDelay(task3, 1, 4, TimeUnit.SECONDS);

        // Stop the scheduler after 20 seconds to clean up
        Runnable stopTask = () -> {
            System.out.println("Shutting down scheduler..."+ Thread.currentThread().getName());
            scheduler.shutdown();
        };
        scheduler.schedule(stopTask, 20, TimeUnit.SECONDS);
    }
}

