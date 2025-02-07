package com.ap.ratelimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucket {
    private final int capacity;
    private final int refillRate; // tokens per second
    private AtomicInteger tokens;
    private long lastRefillTimestamp;

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = new AtomicInteger(capacity);
       // this.lastRefillTimestamp = System.nanoTime();
       this.lastRefillTimestamp = System.currentTimeMillis();
    }

    private synchronized void refill() {
       // long now = System.nanoTime();
       long now = System.currentTimeMillis();
    
        //long timeElapsed = (now - lastRefillTimestamp) / 1_000_000_000; // Convert to seconds
        long timeElapsed = (now - lastRefillTimestamp) / 1000; // Convert to seconds
        int newTokens = (int) (timeElapsed * refillRate);

        if (newTokens > 0) {
            tokens.set(Math.min(capacity, tokens.get() + newTokens));
            lastRefillTimestamp = now;
        }
    }

    public synchronized boolean allowRequest() {
        refill();
        if (tokens.get() > 0) {
            tokens.decrementAndGet();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TokenBucket bucket = new TokenBucket(5, 2); // 5 tokens max, 2 tokens/sec
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + (i + 1) + " allowed: " + bucket.allowRequest());
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}


//The Token Bucket algorithm refills tokens at a constant rate and allows bursts up to the bucket size.