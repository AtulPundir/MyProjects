package com.ap.pre.datastructures.walmart;

public class PrintUsingAlternativeThreads {

    private static final Object lock = new Object();
    private static boolean isT1Turn = true;

    public static void main(String[] args) {
        
        String str = "abcdef";
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < str.length(); i += 2) {
                synchronized (lock) {
                    while (!isT1Turn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() +" " +str.charAt(i)); // Print even-indexed character
                    isT1Turn = false;
                    lock.notify();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i < str.length(); i += 2) {
                synchronized (lock) {
                    while (isT1Turn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + str.charAt(i)); // Print even-indexed character
                    isT1Turn = true;
                    lock.notify();
                }
            }
        });
        
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }

}
