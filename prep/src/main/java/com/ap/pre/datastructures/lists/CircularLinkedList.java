package com.ap.pre.datastructures.lists;

public class CircularLinkedList {

    // Method to create a circular linked list from an array
    public static Node createCircularLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // Return null if the array is empty
        }

        Node head = new Node(arr[0]); // Create the head node
        Node current = head;          // Temporary node to build the list

        // Loop through the array to create nodes and link them
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        // current.next = head;  // TILL HERE ITS A CIRCULAR LINKED LIST, AFTER THAT WE ARE MOVEING BACKWARDS
        //displayCircularList(head);
        for (int i = arr.length - 2; i > 0; i--){
            current.next = new Node(arr[i]);
            current = current.next;

        }

        current.next = head; // Link the last node back to the head to form a circular structure

        return head; // Return the head of the circular linked list
    }

    // Method to display the circular linked list (stopping after one full cycle)
    public static void displayCircularList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)"); // Indicate circular link
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6}; // Input array

        // Create circular linked list
        Node head = createCircularLinkedList(arr);

        // Display the circular linked list
        displayCircularList(head);
    }
}
