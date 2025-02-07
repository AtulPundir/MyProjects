package com.ap.pre.threads.runnable;

public class RunnableAnonymousExample {
    public static void main(String[] args) throws InterruptedException {
        // Using an anonymous class
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running: " + Thread.currentThread().getName());
            }
        });

        thread.start();
        thread.sleep(5000);
  
      // Using a lambda expression
      Thread thread2 = new Thread(() -> {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    });

    thread2.start();

    Thread thread3 = new Thread();
    thread3.join();
    
}

}
