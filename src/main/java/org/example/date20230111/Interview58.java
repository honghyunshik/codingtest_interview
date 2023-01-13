package org.example.date20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node58{
    Node58 next;
    int val;
    Node58(int val){
        this.val = val;
        this.next = null;
    }
}
public class Interview58 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Node58 node = null;
        for(int i=0;i<4;i++){
            int num = Integer.parseInt(st.nextToken());
            node = insertNode(node,num);
        }
        Node58 answer = merge_sort(node);

        while(answer!=null){
            System.out.println(answer.val);
            answer = answer.next;
        }

    }

    public static Node58 insertNode(Node58 node, int val){

        if(node==null) return new Node58(val);
        node.next = insertNode(node.next, val);
        return node;

    }



    public static Node58 merge_sort(Node58 node){

        if(node==null||node.next==null) return node;

        Node58 prev = null, slow = node, fast = node;
        while(fast!=null&&fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        Node58 node1 = merge_sort(node);
        Node58 node2 = merge_sort(slow);

        return merge(node1,node2);


    }
    public static Node58 merge(Node58 l1, Node58 l2){

        Node58 head = new Node58(0), p = head;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1!=null){
            p.next = l1;
        }
        if(l2!=null){
            p.next = l2;
        }
        return head.next;
    }


}
