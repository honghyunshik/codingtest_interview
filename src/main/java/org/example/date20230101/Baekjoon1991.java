package org.example.date20230101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node_1991{
    char val;
    Node_1991 left,right;
    Node_1991(char val){

        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class Baekjoon1991 {

    static Node_1991 head = new Node_1991('A');
    static boolean[] visited;
    static StringBuilder preOrderSb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head,root,left,right);
        }

        visited = new boolean[N+1];
        preOrderSb = new StringBuilder();
        preOrder(head);
        preOrderSb.append("\n");

        visited = new boolean[N+1];
        inOrder(head);
        preOrderSb.append("\n");

        visited = new boolean[N+1];
        postOrder(head);
        preOrderSb.append("\n");

        System.out.println(preOrderSb.toString());


    }

    public static void insertNode(Node_1991 node, char root, char left, char right){

        if(node.val==root){
            if(left!='.') node.left = new Node_1991(left);
            if(right!='.') node.right = new Node_1991(right);
        }else{
            if (node.left!=null) insertNode(node.left,root,left,right);
            if (node.right!=null) insertNode(node.right,root,left,right);
        }
        
    }

    public static void preOrder(Node_1991 node){

        if(visited[node.val-64]) return;
        visited[node.val-64] = true;
        preOrderSb.append(node.val);

        if(node.left!=null) preOrder(node.left);
        if(node.right!=null) preOrder(node.right);

    }

    public static void inOrder(Node_1991 node){

        if(visited[node.val-64]) return;
        visited[node.val-64] = true;

        if(node.left!=null) inOrder(node.left);
        preOrderSb.append(node.val);
        if(node.right!=null) inOrder(node.right);



    }

    public static void postOrder(Node_1991 node){

        if(visited[node.val-64]) return;
        visited[node.val-64] = true;

        if(node.left!=null) postOrder(node.left);
        if(node.right!=null) postOrder(node.right);


        preOrderSb.append(node.val);

    }

}
