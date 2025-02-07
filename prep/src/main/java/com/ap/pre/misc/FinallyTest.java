package com.ap.pre.misc;

public class FinallyTest {

    static void testFunction() {
        try {
            System.out.println("IN try");
            return;
        } catch (Exception e) {
            System.out.println("IN Catch");
            e.printStackTrace();
            return;
        } finally {
            System.out.println("IN FINALLY");
        }
    }

    public static void main(String[] args) {
        testFunction();

        long initialHeap = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        long maxHeap = Runtime.getRuntime().maxMemory() / (1024 * 1024);

        System.out.println("Initial Heap Size: " + initialHeap + " MB");
        System.out.println("Maximum Heap Size: " + maxHeap + " MB");

    
    }

}
