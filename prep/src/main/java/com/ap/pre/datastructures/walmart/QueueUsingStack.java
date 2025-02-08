package com.ap.pre.walmart;

import java.util.Stack;

public class QueueUsingStack {

    static final Stack<Integer> stack1 = new Stack<>(); 
    static final Stack<Integer> stack2 = new Stack<>();

    static void enque(int x) {
        stack1.push(x);

    }

    static int dequeue() {
    
        if (stack2.isEmpty()){
        while (stack1.size() > 0 ){
            stack2.push(stack1.pop());
        }
        }
        if (stack2.isEmpty()){
            return -1;
        }
        return stack2.pop();

    }

    static int peek () {
        System.out.println("SIZE = "+ stack2.size());
        if (stack2.isEmpty()){
            while (stack1.size() > 0 ){
                stack2.push(stack1.pop());
            }
            }
            if (stack2.isEmpty()){
                return -1;
            }
        return stack2.peek();

    }

    static int poll() {


        return 0;

    }

    public static void main(String[] args) {
        enque(1);
        System.out.println("PEEK "+ peek());
        enque(2);
        System.out.println("PEEK "+ peek());
        enque(3);
        System.out.println("DQUE "+ dequeue());
        enque(4);
        System.out.println("DQUE "+ dequeue());
        System.out.println("PEEK "+peek());
        System.out.println("DQUE "+ dequeue());
        System.out.println("DQUE "+ dequeue());
        System.out.println("PEEK "+ peek());
        System.out.println("DQUE "+ dequeue());
        

    }

}
