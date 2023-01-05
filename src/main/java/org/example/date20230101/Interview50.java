package org.example.date20230101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Interview50 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree bt = new BinaryTree();
        for(int i=0;i<5;i++){
            int num = Integer.parseInt(br.readLine());
            bt.root = bt.insertNode(bt.root,num);
        }

    }

}

class BinaryTree{

    Node root;

    public Node insertNode(Node node, int num){

        if(node==null){
            return new Node(num);
        }
        else{
            if(node.val>num) node.left = insertNode(node.left,num);
            else node.right = insertNode(node.right,num);
        }
        return node;
    }

    public Node cirCularSearch(Node node,int num){

        if(node==null) return null;

        if(node.val==num) return node;
        if(node.val>num) return cirCularSearch(node.left,num);
        else return cirCularSearch(node.right,num);
    }

    public Node deleteNode(Node node, int num){

        if(node==null) return null;
        if(node.val>num) node.left = deleteNode(node.left,num);
        else if(node.val<num) node.right = deleteNode(node.right,num);
        else{

            if(node.left==null) return node.right;
            if(node.right==null) return node.left;

            int min = getMinNode(node.right);
            node.right = deleteNode(node.right,min);

        }

        return node;
    }

    public int getMinNode(Node node){

        while(node.left!=null){
            node = node.left;
        }

        return node.val;
    }

}

