package com.ap.pre.walmart;

public class PrintUsingalternativeThreads2 {

    private static final Object lock = new Object();
    private static int turn = 0;

    public static void main(String[] args) {
        
        String str = "abcdefghi";
        Thread t1 = new Thread(() -> {
            printRequest(str, 0);
        });
        Thread t2 = new Thread(() -> {
            printRequest(str, 1);
        });


        Thread t3 = new Thread(() -> {
            printRequest(str, 2);
        });


        Thread t4 = new Thread(() -> {
            printRequest(str, 3);
        });
        
        t1.start();
        t2.start();
        //t3.start();       //Modify the loop increment counter to +=3

        try {
            t1.join();
            t2.join();
           //t3.join();   
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }

    static void printRequest(String str, int myturn){
        for (int i = myturn ; i < str.length(); i += 2) {
            synchronized (lock) {
                while (turn != myturn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + str.charAt(i));
                turn = (turn + 1) % 2; 
                System.out.println("Turn " +turn);
                lock.notify();
            }
        }
    }


    static void printR(String str, int myTurn){

        for (int i = myTurn; i < str.length(); i++){

            synchronized(lock) {

                while (turn != myTurn){
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }

                }
                turn = (turn + 1) % 2;  // turn = (turn + 1) % n;
                lock.notifyAll();

            }


          
        }

    }

}
