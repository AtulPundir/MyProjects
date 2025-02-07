package com.ap.pre.threads;

class SharedResource {
    private int data;
    private boolean isProduced = false;

    public synchronized void produce(int value) {
        while (isProduced) {
            try {
                wait(); // Wait if data is already produced
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;
        System.out.println("Produced: " + data);
        isProduced = true;
        notify(); // Notify a waiting consumer
    }

    public synchronized void consume() {
        while (!isProduced) {
            try {
                wait(); // Wait if no data is available
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed: " + data);
        isProduced = false;
        notify(); // Notify a waiting producer
    }
}

class Producer extends Thread {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.produce(i);
        }
    }
}

class Consumer extends Thread {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.consume();
        }
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();
    }
}
