package com.ap.pre.threads;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class DeadLockAvoidExample {
    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread 1: Locked resource 1");

                        Thread.sleep(100);

                        if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                            try {
                                System.out.println("Thread 1: Locked resource 2");
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println("Thread 1: Could not lock resource 2");
                        }
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("Thread 1: Could not lock resource 1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            try {
                if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread 2: Locked resource 2");

                        Thread.sleep(100);

                        if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                            try {
                                System.out.println("Thread 2: Locked resource 1");
                            } finally {
                                lock1.unlock();
                            }
                        } else {
                            System.out.println("Thread 2: Could not lock resource 1");
                        }
                    } finally {
                        lock2.unlock();
                    }
                } else {
                    System.out.println("Thread 2: Could not lock resource 2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
