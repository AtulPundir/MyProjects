package com.ap.pre.leetcode;

import java.util.Stack;

public class A20bAddTwoNumbers {

 private static Integer returnReverse(Integer num){
        Integer rev = 0 ;
        while (num > 0) {
          int x = num % 10;
          num = num / 10;
          rev = (rev*10) +x;
         
        }
        System.out.println("Reversse : " + rev);
        return rev;

    }

    private static Integer nodeToInteger(ListNode node){
        Integer result = 0 ;
        while (node != null) {
            result =  (result*10) + node.val;
           node = node.next;
        }
        System.out.println("Node to integer : "+ result);
        return result;

    }

    private static ListNode integerToNode(Integer num){
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            int x = num % 10;
            num = num / 10;
            stack.push(x);
        }
        ListNode node = new ListNode(stack.pop());
        ListNode current = node;

        while(!stack.isEmpty()){
            current.next = new ListNode(stack.pop());
            current = current.next;
        }
        return node;

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Integer num1 = nodeToInteger(l1);
        Integer num2 = nodeToInteger(l2);
        Integer sum = returnReverse(num1) + returnReverse(num2);

        //Integer sum = returnReverse(nodeToInteger(l1)) + returnReverse(nodeToInteger(l2));
        
        Integer sumRev = returnReverse(sum);



        return integerToNode(sumRev);
    }

    public static void main(String[] args) {
        // Test case: l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        ListNode result = addTwoNumbers(l1, l2);
        printList(result);  // Expected output: 7 -> 0 -> 8 (since 342 + 465 = 807)
    }
    
    private static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            if(head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
    
}
