package com.ap.pre.walmart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        System.out.println(queue.add(1));
        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue.poll());
        System.out.println(queue.poll());   //returns null
        System.out.println(queue.peek());   //returns null
        //System.out.println(queue.element());    // throws NoSuchElementException
        //System.out.println(queue.remove()); //throws exception NoSuchElement


        Stack<Integer> stack = new Stack<>();
        System.err.println("+++++++++++ SATACK ++++++++++++");
        System.out.println(stack.push(2)); //returns 2
        System.out.println(stack.peek());
        System.out.println(stack.add(3)); //returns true
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //System.out.println(stack.pop());  //EmptyStackException
        System.out.println(stack.push(5));
       // System.out.println(stack.peek()); //EmptyStackException
        System.out.println(stack.add(4));   //returns true
    }

}
