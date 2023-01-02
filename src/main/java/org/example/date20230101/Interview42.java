package org.example.date20230101;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;

public class Interview42 {

    public static void main(String[] args){

        Node node = new Node(3);
        node.left = new Node(9);
        node.right = new Node(20);
        node.right.left = new Node(15);
        node.right.right = new Node(7);

        System.out.println(bfs(node));

    }

    public static int bfs(Node node){

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int depth = 1;
        while(!queue.isEmpty()){

            Node now = queue.poll();
            Node left = now.left;
            Node right = now.right;
            if(left!=null){
                left.depth = now.depth+1;
                queue.add(left);
            }else depth = now.depth;
            if(right!=null){
                right.depth = now.depth+1;
                queue.add(right);
            }else depth = now.depth;
        }

        return depth;
    }
}

class Node{
    int val, depth;
    Node left,right;

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
        this.depth = 1;
    }

    Node(int val, int depth){
        this.val = val;
        this.left = null;
        this.right = null;
        this.depth = depth;
    }
}


