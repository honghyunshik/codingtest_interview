package org.example.date20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinkedNode{
    LinkedNode next;
    int val;
    LinkedNode(int val){
        this.next = null;
        this.val = val;
    }
}
public class Interview60 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        LinkedNode head = null;
        for(String str:input){
            head = insertNode(head,Integer.parseInt(str));
        }
        head = insertionSortList(head);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static LinkedNode insertNode(LinkedNode node, int val){

        if(node==null) return new LinkedNode(val);
        node.next = insertNode(node.next,val);

        return node;
    }

    public static LinkedNode insertionSortList(LinkedNode head) {

        if( head == null ){
            return head;
        }

        LinkedNode helper = new LinkedNode(-1);
        LinkedNode cur = head;
        LinkedNode pre = helper;
        LinkedNode next = null;

        while( cur != null ){
            next = cur.next;

            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }

    public static LinkedNode insertInjection(LinkedNode head){

        LinkedNode node = head;
        LinkedNode headPointer = new LinkedNode(0);
        headPointer.next = head;

        while(node!=null){

            LinkedNode p = node;
            //node보다 작은 노드를 찾기
            while(p.next!=null&&p.next.val>=node.val){
                p = p.next;
            }




            node = node.next;
        }



        return headPointer.next;
    }



}


