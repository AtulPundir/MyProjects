package com.ap.pre.datastructures.walmart;

import java.util.*;

public class TreeTraversalPostOrder {

    // Class to represent a node in the binary tree
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function for postorder traversal (left, right, root)
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    // Helper function for postorder traversal
    private static void postorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;

        // Traverse the left subtree
        postorderHelper(root.left, result);

        // Traverse the right subtree
        postorderHelper(root.right, result);

        // Visit the root
        result.add(root.data);
    }


    public static List<Integer> postorderTraversalWithoutHelper(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            // Traverse the left subtree
            if (root.left != null) result.addAll(postorderTraversalWithoutHelper(root.left));
    
            // Traverse the right subtree
            if (root.right != null) result.addAll(postorderTraversalWithoutHelper(root.right));
    
            // Visit the root
            result.add(root.data);
        }
        return result;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Perform postorder traversal
        //List<Integer> result = postorderTraversal(root);
        List<Integer> result = postorderTraversalWithoutHelper(root);
        System.out.println("Postorder Traversal:");
        System.out.println(result);
    }
}


/*
 
    1
   / \
  2   3
 / \ / \
4  5 6  7


O/P

Postorder Traversal:
[4, 5, 2, 6, 7, 3, 1]
 
 */