package com.ap.pre.walmart;

import java.util.*;

public class TreeTraversalZIgZag {

    // Class to represent a node in the binary tree
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function to perform zig-zag traversal
    public static List<List<Integer>> zigZagTraversalUsingQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // Start with left-to-right traversal

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                // Add node to deque based on the current direction
                if (leftToRight) {
                    currentLevel.addLast(currentNode.data);
                } else {
                    currentLevel.addFirst(currentNode.data);
                }

                // Add child nodes to the queue
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            // Add current level to result
            result.add(new ArrayList<>(currentLevel));
            leftToRight = !leftToRight; // Toggle direction for next level
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

        // Perform zig-zag traversal
        List<List<Integer>> result = zigZagTraversalUsingQueue(root);
        //List<List<Integer>> result = zigZagTraversalUsingStack(root);
        System.out.println("Zig-Zag Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}



/*
 
        1
       / \
      2   3
     / \ / \
    4  5 6  7


O/P

Zig-Zag Traversal:
[1]
[3, 2]
[4, 5, 6, 7]
 
 */