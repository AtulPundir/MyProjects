package com.ap.pre.walmart;

import java.util.*;

public class TreeTraversalInOrder {
    // Class to represent a node in the binary tree
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
    
        while (current != null || !stack.isEmpty()) {
            // Traverse the left subtree by pushing nodes onto the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
    
            // Visit the root (pop from stack)
            current = stack.pop();
            result.add(current.data);


            System.out.println(" "+current.data);
            // Move to the right subtree
            current = current.right;
            System.out.println(" ");
        }
    
        return result;
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            // Traverse the left subtree
            result.addAll(inorderTraversal(root.left));
    
            // Visit the root
            result.add(root.data);
    
            // Traverse the right subtree
            result.addAll(inorderTraversal(root.right));
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
        
        // Perform inorder traversal
        List<Integer> result = inorderTraversalRecursive(root);
        System.out.println("Inorder Traversal:");
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

Inorder Traversal:
[4, 2, 5, 1, 6, 3, 7]
 
 */