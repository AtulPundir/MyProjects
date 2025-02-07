package com.ap.pre.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable {
	 
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" in run method  with Priority " + Thread.currentThread().getPriority());

    }
    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread t1=new Thread(runnable,"T1");
        Thread t2=new Thread(runnable,"T2");
        Thread t3=new Thread(runnable,"T3");
        
        t1.setPriority(1);
        t1.start();
        t2.start();
        
        System.out.println();
        ExecutorService executor =  Executors.newFixedThreadPool(2);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.shutdown();
        
        //The following try catch is to show the use of t.join where we want to finish the main thread at the end
        try {
            t1.join();
            t2.join();
            t3.start();   //Ensures t3 is executed after t2 is completed
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        System.out.println("Main thread ends here");
 
    }

   
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
       try {
        Thread.sleep(2000);
        System.out.println("Thread name "+ Thread.currentThread().getName());
        
       } catch (Exception e) {
        // TODO: handle exception
       }
    }

    MyRunnable2 runnable = new MyRunnable2();
    Thread t1 = new Thread(runnable);

}
