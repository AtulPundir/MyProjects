package com.ap.pre.walmart;

import java.util.LinkedList;
import java.util.Queue;

//Linke Left Node of Binary To its immediate Right Sibling
public class LinkLeftNodeOfBinaryToRightSibling {
    static class Node {
        int data;
        Node left, right, next;

        Node(int data) {
            this.data = data;
            this.left = this.right = this.next = null;
        }
    }

    //RECURSIVE
    public static void connectSiblings(Node root) {
        if (root == null) return;

        // Link left to right
        if (root.left != null) {
            root.left.next = root.right;
        }

        // Link right to the next subtree's left
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        // Recur for left and right subtrees
        connectSiblings(root.left);
        connectSiblings(root.right);
    }


    // ITERATIVE
    public static void connectSiblingsIterative(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (prev != null) {
                    prev.next = current;
                }
                prev = current;

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }

    //RECURSIVE
    public static void connectSiblingsRighttoLeft(Node root) {
        if (root == null) return;

        // Link right to left
        if (root.right != null) {
            root.right.next = root.left;
        }

        // Link left to the next subtree's right
        if (root.left != null && root.next != null) {
            root.left.next = root.next.right;
        }

        // Recur for left and right subtrees
        connectSiblings(root.left);
        connectSiblings(root.right);
    }


      // ITERATIVE
      public static void connectSiblingsRighttoLeftIterative(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (prev != null) {
                    current.next = prev;
                }
                prev = current;

            // Add right and left children to the queue (reverse order)
            if (current.right != null) queue.offer(current.right);
            if (current.left != null) queue.offer(current.left);
            }
        }
    }

    // Helper to print the next links for each level
    public static void printNextLinks(Node root) {
        while (root != null) {
            Node current = root;
            while (current != null) {
                System.out.print(current.data + " -> ");
                if (current.next != null)
                    System.out.print(current.next.data + " ");
                else
                    System.out.print("null ");
                current = current.next;
            }
            System.out.println();
            root = root.left;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("BEFORE");
        printNextLinks(root);
        connectSiblings(root);

        System.out.println("Next links:");
        printNextLinks(root);
    }
}

