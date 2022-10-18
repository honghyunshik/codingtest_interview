package org.example.date20221012;

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
        l1.next.next.next.next.next = new Node();

        Node answer = reverseLinkedList(l1);
    }

    public static Node reverseLinkedList(Node l1){

        Node now = l1;
        Node next = l1.next;

        if(now.data!=null){
            next.next = now;
        }

        return l1;
    }


}

