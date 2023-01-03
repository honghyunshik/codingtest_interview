package org.example.date20230101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Interview47 {

    public static void main(String[] args){

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(4);
        node.right.right = new Node(5);
        ArrayList<Integer> list = makeArray(node);
        System.out.println(list);
        Node head = makeTree(list);
        System.out.println();
        preOrder(head);
        System.out.println(head.left.val);
        System.out.println(head.left.left);
        System.out.println(head.left.right);
        System.out.println(head.right.val);
        System.out.println(head.right.left.val);
        System.out.println(head.right.right.val);

    }

    public static ArrayList<Integer> makeArray(Node node){

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        answer.add(node.val);

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.left==null) answer.add(null);
            else{
                answer.add(now.left.val);
                queue.add(now.left);
            }
            if(now.right==null) answer.add(null);
            else{
                answer.add(now.right.val);
                queue.add(now.right);
            }
        }

        return answer;

    }

    public static Node makeTree(ArrayList<Integer> list){

        Node head = new Node(list.get(0));
        int idx = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(idx<list.size()){
                if(list.get(idx)!=null){
                    now.left = new Node(list.get(idx));
                    queue.add(now.left);
                }
                idx++;
            }
            if(idx<list.size()){
                if(list.get(idx)!=null){
                    now.right = new Node(list.get(idx));
                    queue.add(now.right);
                }
                idx++;
            }
        }



        return head;
    }

    public static void preOrder(Node node){

        System.out.print(node.val);
        if(node.left!=null) preOrder(node.left);
        if(node.right!=null) preOrder(node.right);
    }


}
