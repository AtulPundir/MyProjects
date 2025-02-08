package com.ap.pre.datastructures.walmart;

import java.util.List;
import java.util.ArrayList;

public class RemoveElementFromLinkedList {

    static class Node {
        int data;
        Node  next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
        
    }

    private static Node getLinkedList(List<Integer> list) {
       Node head = new Node(-1);
       Node current = head;
        for (int i = 0; i <list.size(); i++){
            current.next = new Node(list.get(i));
            current = current.next;
            
        }
        head = head.next;
        return head;
    }

    private static Node removeElement(Node node, int k) {
       
        if (k == 0) {
            return node.next;
        }

        Node current = node ;
        Node previous = null;
        int count = 0;

        while (current != null && count < k ){
            previous = current;
            current = current.next;
            count++;
            
        }

        if (current == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        previous.next = current.next;

        return node;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Node linkedList = getLinkedList(list);
        int k = 4;
        linkedList = removeElement(linkedList, k); //here k is index

    }

}
