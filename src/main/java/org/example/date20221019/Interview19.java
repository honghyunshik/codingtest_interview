package org.example.date20221019;

//파이썬 알고리즘 인터뷰 책 19번 문제 - 역순 연결 리스트(233p)
//인덱스 m에서 n까지를 역순으로 만들어라. 인덱스 m은 1부터 시작한다.
public class Interview19 {

    public static void main(String[] args){

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        Node answer = reverseLinkedList(node,3,5);
        while(answer!=null){
            System.out.print(answer.data + " -> ");
            answer = answer.next;
        }

    }

    public static Node reverseLinkedList(Node node, int a, int b){

        Node root = node;
        Node start = node;    //역순 하기 전 start node

        for(int i=0;i<a-1;i++){
            start = start.next;
        }
        Node end = start.next;      //역순 한 후 end node
        Node prev = new Node();

        for(int i=0;i<b-a+1;i++){






        }


        return root;
    }



}
