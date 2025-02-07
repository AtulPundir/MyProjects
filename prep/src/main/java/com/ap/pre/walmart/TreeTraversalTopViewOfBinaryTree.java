package com.ap.pre.walmart;

import java.util.*;

public class TreeTraversalTopViewOfBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void printTopView(TreeNode root) {
        if (root == null) return;

        Map<Integer, Integer> topViewMap = new TreeMap<>(); // Map to store the first node at each horizontal distance

        // Queue for level order traversal, storing nodes and their horizontal distance
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, 0));

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int hd = current.getValue();

            // If horizontal distance is not yet in map, add it
            topViewMap.putIfAbsent(hd, node.data);

            // Add left and right children to the queue with their respective HD
            if (node.left != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, hd + 1));
            }
        }

        // Print the nodes in the top view (sorted by HD)
        for (int value : topViewMap.values()) {
            System.out.print(value + " ");
        }
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
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        // Print the top view
        System.out.println("Top view of the binary tree:");
        printTopView(root);
    }
}




/*
 
        1
       / \
      2   3
     / \ / \
    4  5 6  7
   / \
  8   9


O/P

Top view of the binary tree:
8 4 2 1 3 7 %   
 
 */