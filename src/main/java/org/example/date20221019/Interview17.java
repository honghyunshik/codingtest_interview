package org.example.date20221019;

//파이썬 알고리즘 인터뷰 책 14번 문제 - 두 정렬 리스트의 병합(213p)
//연결 리스트를 입력받아 페어 단위로 스왑하라
public class Interview17 {

    public static void main(String[] args){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);


        Node answer = pairSwap(node);
        while(answer!=null){
            System.out.print(answer.data + " -> ");
            answer = answer.next;
        }
    }

    public static Node pairSwap(Node node){

        /*Node prev = new Node();
        Node root = node.next;

        while(node!=null && node.next!=null){

            Node next = node.next;
            node.next = next.next;
            next.next = node;

            prev.next = next;
            prev = node;

            node = node.next;

        }
        return root;*/

        Node root = new Node(node.data);
        root.next = node.next;

        Node prev = new Node(root.data);     //이전 노드를 저장   초깃값은 첫번째로 들어오는 값

        while(node!=null&&node.next!=null){

            Node next = node.next;
            node.next = next.next;
            next.next = node;

            prev.next = next;
            prev = node;

            node = node.next;


        }

        return root.next;
    }

    public static Node pairSwap2(Node node){

        if(node!=null&&node.next!=null){
            Node p = node.next;
            node.next = pairSwap2(p.next);
            p.next = node;
            return p;
        }

        return node;
    }
}


class Node{

    Integer data;    //데이터가 저장될 필드
    Node next;      //다음 노드를 가리키는 필드

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public Node(){
        this.next = null;
        this.data = null;
    }


}




