package com.ap.pre.datastructures.walmart;

public class MergeTwoSortedLInkedList {

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data  = data;
            this.next = null;
        }

    }

    static Node mergeSortedNodes(Node node1, Node node2){
        
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }

        Node head = new Node(-1);
        Node current = head;

        while (node1 != null && node2 != null) {
        if (node1.data < node2.data){
            current.next = node1;
            node1 = node1.next;
        } else {
            current = node2;
            node2 = node2.next;
        }
    }

        if (node1 != null){
            current.next = node1;
        } else if (node2 != null){
            current.next = node2;
        }
        
        return head.next;

    }

    public static void main(String[] args) {
        
    }

}
