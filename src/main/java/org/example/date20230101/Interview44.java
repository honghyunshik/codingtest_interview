package org.example.date20230101;

public class Interview44 {

    static int max = 0;

    public static void main(String[] args){

        Node node = new Node(5);
        node.left = new Node(4);
        node.left.left = new Node(1);
        node.left.right = new Node(1);
        node.right = new Node(5);
        node.right.right = new Node(5);
        node.right.right.right = new Node(5);
        node.right.left = new Node(5);


        Node node1 = new Node(1);
        node1.left = new Node(4);
        node1.left.left = new Node(4);
        node1.left.right = new Node(4);
        node.left.left.left = new Node(4);
        node1.right = new Node(5);
        node1.right.right = new Node(5);

        postOrder(node);

        System.out.println(max);
    }

    public static int postOrder(Node node){

        if(node==null){
            return 0;
        }

        int left = postOrder(node.left);
        int right = postOrder(node.right);

        int forLeft = 0;
        int forRight = 0;

        if(node.left!=null&&node.val==node.left.val){
            forLeft = left+1;
        }
        if(node.right!=null&&node.val==node.right.val){
            forRight = right+1;
        }
        max = Math.max(max, forLeft+forRight);
        return Math.max(forLeft,forRight);
    }


}


