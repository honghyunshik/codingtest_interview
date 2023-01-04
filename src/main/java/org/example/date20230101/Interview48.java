package org.example.date20230101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Interview48 {

    static boolean answer = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] array = new int[input.length];
        for(int i=0;i<array.length;i++){
            array[i] = Integer.parseInt(input[i]);
        }
        Node head = makeTree(array);
        isHeightBalance(head,0);
        System.out.println(answer);
        //preOrder(head);

    }

    public static Node makeTree(int[] array){

        Node head = new Node(array[0]);
        Queue<Node> queue = new LinkedList<>();
        int idx = 1;
        queue.add(head);
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(idx<array.length){
                if(array[idx]!=-1){
                    now.left = new Node(array[idx]);
                    queue.add(now.left);
                }idx++;
            }
            if(idx<array.length){
                if(array[idx]!=-1){
                    now.right = new Node(array[idx]);
                    queue.add(now.right);
                }
            }idx++;
        }

        return head;
    }

    public static void preOrder(Node node){

        System.out.println(node.val);
        if(node.left!=null) preOrder(node.left);
        if(node.right!=null) preOrder(node.right);
    }

    public static int isHeightBalance(Node node, int depth){

        if(node.left==null&&node.right==null){
            return depth;
        }

        int left = 0, right = 0;
        if(node.left!=null) {
            left = isHeightBalance(node.left, depth+1);
        }
        if(node.right!=null) {
            right = isHeightBalance(node.right, depth+1);
        }
        if(Math.abs(left-right)>1) answer = false;


        return Math.max(left,right);
    }
}
