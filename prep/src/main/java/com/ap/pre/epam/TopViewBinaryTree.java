package com.ap.pre.epam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Node {
    int val;
    Node left, right;

    Node (int val){
        this.val = val;
        left = right = null;

    }
}


public class TopViewBinaryTree {
    
    public static void topView(Node root, int hd, int level, Map<Integer, int[]> map) {
        if (root == null) return;

        if (!map.containsKey(hd) || level < map.get(hd)[1]) {
            map.put(hd, new int[]{root.val, level});
        }
        topView(root.left, hd - 1, level + 1, map);
        topView(root.right, hd + 1, level + 1, map);
    }

    public static List<Integer> getTopView(Node root) {
        Map<Integer, int[]> map = new TreeMap<>();
        topView(root, 0, 0, map);

        List<Integer> result = new ArrayList<>();
        for (int[] value : map.values()) {
            result.add(value[0]);
        }
        return result;
    }


    public static void main(String[] args) {

        /* root:
                 1
               /   \
              2     3
             / \   / \
            4   5  6  7
           / \ 
          8   9
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        System.out.println(getTopView(root));   //O/P [8, 4, 2, 1, 3, 7]


/* root2:
                1
               / \
              2   3
             / \   \
            4   5   6
               /
              7
        */

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.right = new Node(6);
        root2.left.right.left = new Node(7);


        System.out.println(getTopView(root2));    //O/P 4, 2, 1, 3, 6]
    }

}



 
