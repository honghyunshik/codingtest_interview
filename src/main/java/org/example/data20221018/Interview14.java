package org.example.data20221018;

//파이썬 알고리즘 인터뷰 책 14번 문제 - 두 정렬 리스트의 병합(213p)
//정렬되어 있는 두 연결 리스트를 합쳐라
public class Interview14 {

    public static void main(String[] args){

        //deque 1->2->4 와 1->3->4 생성
        LinkedList linkedList = new LinkedList();

        //LinkedList l1 생성 : 1 -> 2 -> 4
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(4);

        //LinkedList l2 생성 : 1 -> 3 -> 4
        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        Node answer = linkedList.mergeTowList(l1,l2);
        while(answer!=null){
            System.out.print(answer.data + " -> ");
            answer = answer.next;
        }

    }
}

class LinkedList{

    public Node mergeTowList(Node l1, Node l2){

        //l1이 null이거나   or    l1이 l2보다 클 때 l1과 l2를 스왑(왼쪽에 더 작은 수를 둔다)
        if(l1==null||(l2!=null&&l1.data>l2.data)){
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        if(l1!=null) {
            System.out.println("l1 : " + l1.data);
            l1.next = mergeTowList(l1.next, l2);
        }


        return l1;
    }

    public Node mergeTwoList2(Node l1, Node l2){

        if(l1==null||(l2!=null&&l1.data>l2.data)){
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        if(l1!=null){
            l1.next = mergeTowList(l1.next,l2);
        }
        return l1;

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
