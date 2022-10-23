package org.example.date20221014;


//파이썬 알고리즘 인터뷰 책 26번 문제 - 원형 데크 디자인(259p)
public class Interview26 {
    public static void main(String[] args){
        MyCircularDeque deque = new MyCircularDeque(5);
        deque.insertFront(1);
        deque.insertFront(2);
        deque.insertFront(3);
        deque.insertLast(4);
        deque.insertLast(5);
        deque.deleteFront();
        deque.insertLast(5);
        Node node = deque.head;
        while(node!=null){
            System.out.print(node.data + " -> ");
            node = node.right;
        }
    }
}

class MyCircularDeque{

    Node head;      //첫 노드를 저장
    Node tail;      //끝 노드를 저장
    int size;       //Deque의 사이즈를 저장
    int len;        //현재 Deque에 들어있는 item의 개수

    MyCircularDeque(int size){
        head = new Node();
        tail = new Node();
        this.size = size;
        len = 0;
        head.right = tail;
        tail.left = head;
    }

    //데크 처음에 아이템을 추가하고 성공할 경우 true를 리턴한다
    public boolean insertFront(int item){

        if(len==size){
            return false;
        }else{
            len++;
            _add(head,item);
            return true;
        }



    }

    public void _add(Node node, int num){

        Node next = node.right;
        Node newNode = new Node(num);
        node.right = newNode;
        next.left = newNode;
        newNode.left = node;
        newNode.right = next;

    }

    public void _delete(Node node){

        Node prev = node.left;
        Node next = node.right;

        prev.right = next;
        next.left = prev;
    }

    //데크 마지막에 아이템을 추가하고 성공할 경우 true를 리턴한다
    public boolean insertLast(int item){

        if(len==size){
            return false;
        }else{
            len++;
            _add(tail.left,item);
            return true;
        }


    }

    //데크 처음에 아이템을 삭제하고 성공할 경우 true를 리턴한다
    public boolean deleteFront(){
        if(len==0){
            return false;
        }else{
            len--;
            _delete(head.right);
            return true;
        }

    }

    //데크 마지막 아이템을 삭제하고 성공할 경우 true를 리턴한다
    public boolean deleteLast(){

        if(len==0){
            return false;
        }else{
            len--;
            _delete(tail.left);
            return true;
        }
    }

    //데크의 첫 번째 아이템을 가져온다. 데크가 비어 있다면 -1을 리턴한다
    public int getFront(){

        if(len==0){
            return -1;
        }else{
            return head.right.data;
        }
    }

    //데크의 마지막 아이템을 가져온다. 데크가 비어 있다면 -1을 리턴한다
    public int getRear(){

        if(len==0){
            return -1;
        }else{
            return tail.left.data;
        }
    }

    //데크가 비어 있는지 여부를 판별한다
    public boolean isEmpty(){

        if(len==0){
            return true;
        }
        return false;
    }

    //데크가 가득 차 있는지 여부를 판별한다
    public boolean isFull(){
        if(len==size){
            return true;
        }
        return false;
    }


}


class Node{

    Integer data;    //데이터가 저장될 필드
    Node left;      //왼쪽 노드를 가리킴
    Node right;     //오른쪽 노드를 가리킴

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(){
        this.left = null;
        this.right = null;
        this.data = null;
    }


}


