package com.ap.pre.epam;

class Node {
    int val;
    Node left, right;

    Node (int val){
        this.val = val;
        left = right = null;

    }
}


public class TopViewBinaryTree {

    private static void getTopView(Node root) {
       Node result ;


        if (root == null) return;

        Node Current = root;

        while (){

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

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        getTopView(root);
    }

}
