package com.ap.pre.datastructures.walmart;

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


        List<Integer> result = new ArrayList<>();
        System.out.println();

        traverse(root,result);
        System.out.println(result);
    }



    public static List<Integer> traverse(TreeNode root, List<Integer> result) {
        Set<Integer> uniqueNodes = new LinkedHashSet<>();
        if (root != null) {
            if (root.left != null) {
                getLeft(root.left,uniqueNodes);
            }
            uniqueNodes.add(root.data);
            if (root.right != null) {
                getRight(root.right,uniqueNodes);
            }
        }
        result.addAll(uniqueNodes);
        return result;
    }

    private static  void getLeft(TreeNode left, Set<Integer> result) {
        if (left == null) return;
        getLeft(left.left, result);
        result.add(left.data); 
       
    }

    private static  void getRight(TreeNode right, Set<Integer> result) {
        while (right != null){
           result.add(right.data);
           right = right.right;
        }
       
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