package com.ap.ratelimiter;

import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket {
    private final int capacity;
    private final int leakRate; // requests per second
    private Queue<Long> queue = new LinkedList<>();

    public LeakyBucket(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        leak(); // Process queued requests

        if (queue.size() < capacity) {
            queue.offer(now);
            return true;
        }
        return false; // Request dropped
    }

    private void leak() {
        long now = System.currentTimeMillis();
        while (!queue.isEmpty() && (now - queue.peek() >= 1000 / leakRate)) {
            queue.poll(); // Remove processed requests
        }
    }

    public static void main(String[] args) {
        LeakyBucket bucket = new LeakyBucket(5, 2); // 5 capacity, leaks 2 requests/sec
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + (i + 1) + " allowed: " + bucket.allowRequest());
            try { Thread.sleep(300); } catch (InterruptedException e) {}
        }
    }
}

//The Leaky Bucket processes requests at a constant rate, discarding excess requests when the queue is full.