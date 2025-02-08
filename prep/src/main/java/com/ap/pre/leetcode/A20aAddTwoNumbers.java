package com.ap.pre.leetcode;

import java.math.BigInteger;
import java.util.Stack;

 /*class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}*/

public class A20aAddTwoNumbers {
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String numStr1 = buildNumberString(l1);
        String numStr2 = buildNumberString(l2);
        
        BigInteger num1 = new BigInteger(numStr1);
        BigInteger num2 = new BigInteger(numStr2);
        BigInteger sum = num1.add(num2);
        
        return buildListFromNumber(sum);
    }
    
    private static String buildNumberString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.reverse().toString();
    }
    
    private static ListNode buildListFromNumber(BigInteger num) {
        String numStr = num.toString();
        String reversed = new StringBuilder(numStr).reverse().toString();
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (char ch : reversed.toCharArray()) {
            int digit = ch - '0';
            current.next = new ListNode(digit);
            current = current.next;
        }
        return dummy.next;
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

