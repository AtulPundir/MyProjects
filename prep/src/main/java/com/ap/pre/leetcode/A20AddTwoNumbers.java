package com.ap.pre.leetcode;

//EASY
public class A20AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        
        // Iterate while there is a node in l1 or l2 or there is a carry.
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // Update carry for next iteration.
            carry = sum / 10;
            // Create new node with the digit value of (sum mod 10)
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return head.next;
    }
    
    // For testing the solution
    public static void main(String[] args) {
        // Test case 1: [2,4,3] + [5,6,4] => [7,0,8]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        ListNode result = addTwoNumbers(l1, l2);
        printList(result); // Expected output: 7 -> 0 -> 8

        // Test case 2: [9,9,9,9,9,9,9] + [9,9,9,9] => [8,9,9,9,0,0,0,1]
        ListNode t1 = new ListNode(9);
        t1.next = new ListNode(9);
        t1.next.next = new ListNode(9);
        t1.next.next.next = new ListNode(9);
        t1.next.next.next.next = new ListNode(9);
        t1.next.next.next.next.next = new ListNode(9);
        t1.next.next.next.next.next.next = new ListNode(9);
        
        ListNode t2 = new ListNode(9);
        t2.next = new ListNode(9);
        t2.next.next = new ListNode(9);
        t2.next.next.next = new ListNode(9);
        
        ListNode result2 = addTwoNumbers(t1, t2);
        printList(result2); // Expected output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
    }
    
    public static void printList(ListNode head) {
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



class ListNode {
  int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) {
         this.val = val; 
         this.next = next; 
        }
}