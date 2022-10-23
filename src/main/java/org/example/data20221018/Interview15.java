package org.example.data20221018;

import org.example.data20221018.Node;

//파이썬 알고리즘 인터뷰 책 15번 문제 - 역순 연결 리스트(219p)
//연결 리스트를 뒤집어라
public class Interview15 {

    public static void main(String[] args){

        //Linkedlist l1 생성 : 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);


        Node answer = reverseLinkedList1(l1,null);
        System.out.println("first : " + answer.data);
        while(answer!=null){
            System.out.print(answer.data + " -> ");
            answer = answer.next;
        }
        System.out.print("null");

    }

    //재귀함수 활용
    public static Node reverseLinkedList1(Node head, Node newHead){

/*

        if(head!=null){
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            System.out.println("newHead : " + newHead.data);

            return reverseLinkedList1(next,newHead);
        }
*/


        if(head!=null){
            Node nowHead = new Node(head.data);
            nowHead.next = newHead;

            reverseLinkedList1(head.next,nowHead);
        }

        return newHead;
    }


    public static Node reverseLinkedList2(Node l1){


        Node prev = null;

        while(l1!=null){

            Node now = l1;
            l1 = l1.next;
            now.next = prev;
            prev = now;
        }
        return prev;


    }



}

