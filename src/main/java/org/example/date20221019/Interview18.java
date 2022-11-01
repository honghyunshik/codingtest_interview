package org.example.date20221019;

//파이썬 알고리즘 인터뷰 책 18번 문제 - 홀짝 연결 리스트(233p)
//연결 리스트를 홀수 노드 다음에 짝수 노드가 오도록 재구성하라. 공간 복잡도 O(1), 시간 복잡도 O(n)으로 풀이하라.
public class Interview18 {

    public static void main(String[] args){

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node answer = getPairLinkedList(node);
        while(answer!=null){
            System.out.print(answer.data + " -> ");
            answer = answer.next;
        }
    }

    public static Node getPairLinkedList(Node node){

        Node odd = node;        //홀수 LinkedList
        Node even = node.next;      //짝수 LinkedList
        Node even_head = node.next;

        //홀수 끝 -> 짝수
        while(odd!=null&&odd.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = even_head;


        return node;
    }

}
