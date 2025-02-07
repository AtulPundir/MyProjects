package com.ap.pre.walmart;

import java.util.LinkedList;

public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;
        //Node prev;

        Node (int data){
            this.data = data;
            this.next = null;
            //this.prev = null;
        }

    }

    private static Node createLinkedList(int[] arr) {
        Node head =  new Node(arr[0]);
        Node current = head;
       for (int i = 1; i < arr.length; i++){
        current.next = new Node(arr[i]);
        current = current.next;
       }
       return head;
    }


    private static Node reverse(Node ll) {
        Node prev = null;
        Node next = null;
        Node current = ll;

        while (current != null) {
            next = current.next;        //just for ref to make it to currrent in last
            current.next = prev;

            prev = current;
            current = next;
        }
        return prev;
      
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6}; // Input array


        Node ll  = createLinkedList(arr);

        reverse(ll);
    }




    private static LinkedList<Integer> createLinkedList2(int[] arr) {
        // Node head =  new Node();
         LinkedList<Integer> ll = new LinkedList<>();
        for(int x : arr ){
         ll.add(x);
        }
 
     
 
        return ll;
     }

}
