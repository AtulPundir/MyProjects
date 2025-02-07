package com.ap.ratelimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowCounter {
    private final int windowSizeMillis;
    private final int maxRequests;
    private AtomicInteger counter = new AtomicInteger(0);
    private long windowStartTime;

    public SlidingWindowCounter(int maxRequests, int windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
        this.windowStartTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        if (now - windowStartTime >= windowSizeMillis) {
            counter.set(0);
            windowStartTime = now;
        }

        if (counter.get() < maxRequests) {
            counter.incrementAndGet();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingWindowCounter counter = new SlidingWindowCounter(5, 1000); // 5 requests per second
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + (i + 1) + " allowed: " + counter.allowRequest());
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
    }
}


//The Sliding Window Counter tracks requests in fixed time windows and limits the number of requests per window.