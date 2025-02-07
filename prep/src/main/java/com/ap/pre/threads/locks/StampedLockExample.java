package com.ap.pre.threads.locks;
import java.util.concurrent.locks.StampedLock;


public class StampedLockExample {

    public static void main(String[] args) {
        StampedLock lock = new StampedLock();
        ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

        long stamp = lock.tryOptimisticRead();  /* @return a valid optimistic read stamp, or zero if exclusively locked*/

        try {
            // Perform read
            if (!lock.validate(stamp)) {
                stamp = lock.readLock();
                // Perform read again
            }
        } finally {
            lock.unlock(stamp);
        }
        
        // Writing
        long writeStamp = lock.writeLock();
        try {
            // Perform write
        } finally {
            lock.unlock(writeStamp);
        }
        
    }




}
