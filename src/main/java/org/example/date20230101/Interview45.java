package org.example.date20230101;

public class Interview45 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){

        Node node = new Node(4);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right = new Node(7);
        node.right.left = new Node(6);
        node.right.right = new Node(9);
        preOrder(node);
        swapTree(node);
        sb.append("\n");
        preOrder(node);
        System.out.println(sb.toString());

    }

    public static void preOrder(Node node){

        sb.append(node.val);
        if(node.left!=null) preOrder(node.left);
        if(node.right!=null) preOrder(node.right);
    }

    public static void swapTree(Node node){

        if(node==null) return;

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        swapTree(node.left);
        swapTree(node.right);
    }


}
