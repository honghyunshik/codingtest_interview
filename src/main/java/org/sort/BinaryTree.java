package org.sort;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        for(int i=1;i<5;i++){
            binaryTree.insertNode(binaryTree.root,i);
            binaryTree.insertNode(binaryTree.root,i);
        }
        Node root = binaryTree.root;
        binaryTree.preOrder(root);
    }
    private class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }
    Node root;

    Node insertNode(Node root, int data){

        if(this.root==null) {
            this.root = new Node(data);
            return root;
        }
        if(root==null) {
            return new Node(data);
        }
        if(data<root.data) root.left = insertNode(root.left,data);
        else if(data>root.data) root.right = insertNode(root.right,data);
        return root;
    }

    //dfs 탐색
    void preOrder(Node root){

        if(root==null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    //bfs 탐색
    void bfs(Node root){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node now = queue.poll();
            System.out.println(now.data);
            if(now.left!=null) queue.add(now.left);
            if(now.right!=null) queue.add(now.right);
        }
    }


}

