package com.ap.pre.datastructures.walmart;

import java.util.LinkedList;
import java.util.Queue;

import javax.resource.spi.IllegalStateException;

public class StackFromQueue {

    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    static void push (int x){
        queue1.add(x);
    }

    static int pop ()  throws IllegalStateException {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last remaining element in queue1 is the element to pop
        int poppedElement = queue1.poll();

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;

    }

    static int peek () throws IllegalStateException { 
        if (queue2.isEmpty()){
            while (!queue1.isEmpty()){
                queue2.add(queue1.poll());

            }
        }
        if (queue2.isEmpty()){
            throw new IllegalStateException("stack is empty");
        }
        return queue2.peek();
    
    }
    
    public static void main(String[] args) throws IllegalStateException {
        push(1);
        System.out.println("PEEK "+ peek());
        push(2);
        System.out.println("PEEK "+ peek());
        push(3);
        System.out.println("DQUE "+ pop());
        push(4);
        System.out.println("DQUE "+ pop());
        System.out.println("PEEK "+peek());
        System.out.println("DQUE "+ pop());
        System.out.println("DQUE "+ pop());
        System.out.println("PEEK "+ peek());
        System.out.println("DQUE "+ pop());
        
    }

}
