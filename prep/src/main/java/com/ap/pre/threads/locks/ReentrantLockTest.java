package com.ap.pre.threads.locks;

import java.util.concurrent.locks.ReentrantLock;

class SharedCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

public class ReentrantLockTest {
    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();
    }
}
