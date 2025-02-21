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
        
       if (node1 == null) return node2;
       if (node2 == null) return node1;

       Node head = new Node(Integer.MIN_VALUE);
       Node current = head;

       while (node1 != null && node2 != null){
        if (node1.data <= node2.data){
            current.next = node1;
            node1 = node1.next;
        } else {
            current.next =node2;
            node2 = node2.next;
        }
        current = current.next;
       }

       //Attaching remaining node;
       current.next = (node1 != null) ? node1 : node2;
/*
       if (node1 != null){
        current.next = node1
       }

       if (node2 != null){
        current.next = node2;
       } 
         */
       return head.next;

    }

    public static void main(String[] args) {
        Node node1 =new Node(1);
        node1.next =new Node(3);
        node1.next.next =new Node(4);
        node1.next.next.next =new Node(7);
        node1.next.next.next.next =new Node(8);
        node1.next.next.next.next.next =new Node(9);

        Node node2 =new Node(2);
        node2.next =new Node(2);
        node2.next.next =new Node(3);
        node2.next.next.next =new Node(5);
        node2.next.next.next.next =new Node(10);


        Node result = mergeSortedNodes(node1, node2);


        while (result != null){
            System.out.println(result.data);
            result = result.next;

        }

        
    }

}
