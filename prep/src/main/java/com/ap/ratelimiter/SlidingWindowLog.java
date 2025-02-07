package com.ap.ratelimiter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog {
    private final int maxRequests;
    private final int windowSizeMillis;
    private Queue<Long> timestamps = new LinkedList<>();

    public SlidingWindowLog(int maxRequests, int windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        while (!timestamps.isEmpty() && now - timestamps.peek() >= windowSizeMillis) {
            timestamps.poll(); // Remove old requests
        }

        if (timestamps.size() < maxRequests) {
            timestamps.offer(now);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingWindowLog log = new SlidingWindowLog(5, 1000); // 5 requests per second
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + (i + 1) + " allowed: " + log.allowRequest());
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
    }
}


//The Sliding Window Log keeps timestamps of requests and removes old ones.