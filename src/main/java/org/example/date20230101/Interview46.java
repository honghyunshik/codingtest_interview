package org.example.date20230101;

public class Interview46 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){

        Node node1 = new Node(1);
        node1.left = new Node(3);
        node1.left.left = new Node(5);
        node1.right = new Node(2);

        Node node2 = new Node(2);
        node2.left = new Node(1);
        node2.left.right = new Node(4);
        node2.right = new Node(3);
        node2.right.right = new Node(7);

        preOrder(node1);
        sb.append("\n");
        preOrder(node2);
        sb.append("\n");
        sumTree(node1,node2);
        preOrder(node1);
        System.out.println(sb.toString());

    }

    public static void preOrder(Node node){

        if(node==null) return;
        sb.append(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void sumTree(Node node1, Node node2){

        node1.val+=node2.val;
        if(node2.left!=null){
            if(node1.left==null){
                node1.left = new Node(0);
            }
            sumTree(node1.left,node2.left);
        }
        if(node2.right!=null){
            if(node1.right==null){
                node1.right = new Node(0);
            }
            sumTree(node1.right,node2.right);
        }



    }
}
