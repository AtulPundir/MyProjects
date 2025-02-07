package com.ap.pre.walmart;

public class SortLinkedList {

    static class Node {
        int data;
        Node next;

        Node (int data){
            this.data = data;
            this.next = null;
        }
    }

     public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMiddle(head);
        Node secondHalf = mid.next;
        mid.next = null;

        // Step 2: Recursively sort both halves
        Node left = sortList(head);
        Node right = sortList(secondHalf);
        return merge(left, right);
    }

    private static Node getMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node node1, Node node2) {
        Node head = new Node(-1);
        Node current = head;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }

        if (node1 != null) {
            current.next = node1;
        } else if (node2 != null) {
            current.next = node2;
        }

        return head.next;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.print("Original List: ");
        printList(head);

        // Sort the list
        head = sortList(head);

        System.out.print("Sorted List: ");
        printList(head);
    }

}
