package com.ap.pre.walmart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeFlipBInaryTree {
    static class Node {
        int data;
        Node left, right;
    
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // Function to flip the binary tree
    public static Node flipTree(Node root) {
        if (root == null) {
            return null;
        }

        // Recursively flip the left and right subtrees
        Node flippedLeft = flipTree(root.left);
        Node flippedRight = flipTree(root.right);

        // Swap the left and right children
        root.left = flippedRight;
        root.right = flippedLeft;

        return root;
    }

     public static Node flipTreeIterativeUsingQueue(Node root) {
        if (root == null) {
            return null;
        }

        // Use a queue for level-order traversal (you can also use a stack for DFS)
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Swap the left and right children
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add the children to the queue for further processing
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return root;
    }

    public static Node flipTreeIterativeUsingStack(Node root) {
        if (root == null) {
            return null;
        }
    
        // Use a stack for DFS traversal
        Stack<Node> stack = new Stack<>();
        stack.push(root);
    
        while (!stack.isEmpty()) {
            Node current = stack.pop();
    
            // Swap the left and right children
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
    
            // Push the children to the stack for further processing
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
    
        return root;
    }

    // Function to perform an in-order traversal and print the tree
    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //This is done to travese and print and nothing related to logic
        System.out.println("Original Tree (In-order Traversal):");
        inOrderTraversal(root);
        System.out.println();

        // Flip the binary tree
        root = flipTree(root);
        //root = flipTreeIterativeUsingQueue(root);
        //root = flipTreeIterativeUsingStack(root);

        System.out.println("Flipped Tree (In-order Traversal):");
        inOrderTraversal(root);
        System.out.println();
    }

}

/*

Original Binary Tree:
        1
      /   \
     2     3
    / \   / \
   4   5 6   7


Flipped Binary Tree:
        1
      /   \
     3     2
    / \   / \
   7   6 5   4


O/P

Original Tree (In-order Traversal):
4 2 5 1 6 3 7 
Flipped Tree (In-order Traversal):
7 3 6 1 5 2 4 


 */