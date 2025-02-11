package com.ap.pre.datastructures.walmart;

import java.util.*;

public class TreeTraversalLevelOrder {

    // Class to represent a node in the binary tree
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function for normal level-order traversal
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.data);

                // Add child nodes to the queue
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            // Add the current level's nodes to the result
            result.add(currentLevel);
        }

        return result;
    }

    public static List<List<Integer>> levelOrderTraversalRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;  // Handle the case when the root is null
    
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
    
        while (!currentLevel.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
    
            for (TreeNode node : currentLevel) {
                levelValues.add(node.data);  // Add current node's value to level values
                if (node.left != null) nextLevel.add(node.left);  // Add left child to next level
                if (node.right != null) nextLevel.add(node.right);  // Add right child to next level
            }
    
            result.add(levelValues);  // Add the current level's values to result
            currentLevel = nextLevel;  // Move to the next level
        }
    
        return result;
    }


    public static List<Integer> levelOrderTraversalRecursive1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;  // Handle the case when the root is null
    
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
    
        while (!currentLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
    
            for (TreeNode node : currentLevel) {
                result.add(node.data);  // Add current node's value to result
                if (node.left != null) nextLevel.add(node.left);  // Add left child to next level
                if (node.right != null) nextLevel.add(node.right);  // Add right child to next level
            }
    
            currentLevel = nextLevel;  // Move to the next level
            System.out.println("Level-Order Traversal lLOOP:");
            for (int x : result){
                System.out.print(x);
    
            }
            System.out.println();
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

        // Perform level-order traversal
        List<List<Integer>> result = levelOrderTraversalRecursive(root);
        List<Integer> result1 = levelOrderTraversalRecursive1(root);

        System.out.println("Level-Order Traversal levelOrderTraversalRecursive1:");
        for (int x : result1){
            System.out.print(x);

        }
        System.out.println("Level-Order Traversal:");
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

Level-Order Traversal:
[1]
[2, 3]
[4, 5, 6, 7]
 
 */