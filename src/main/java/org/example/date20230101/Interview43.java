package org.example.date20230101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Interview43 {

    static ArrayList<ArrayList<Integer>> nodeList;
    static int depth = 0;

    public static void main(String[] args) throws IOException {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);



    }

    public static void dfs(Node node, int depth, String road){

        if(node.left!=null) dfs(node.left,depth+1,road + node.val + " < ");
        if(node.right!=null) dfs(node.right, depth+1, road + node.val + " < ");

    }


}

