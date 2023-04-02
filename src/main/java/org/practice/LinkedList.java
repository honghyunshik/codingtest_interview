package org.practice;

public class LinkedList<T> {

    private class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
    }

    Node head;
    Node tail;

    int size = 0;

    void insertTop(T node){

        if(size==0) {
            head = new Node(node);
            tail = head;
        }
        else{
            Node newNode = new Node(node);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void insertLast(T node){
        if(size==0) insertTop(node);
        else{
            Node newNode = new Node(node);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    void insert(T node, int idx){

        if(idx==0) insertTop(node);
        if(size<idx) throw new RuntimeException("그곳엔 넣을 수 없습니다");
        Node temp = head;
        for(int i=0;i<idx-1;i++){
            temp = temp.next;
        }
        Node next = temp.next;
        Node newNode = new Node(node);
        temp.next = newNode;
        newNode.next = next;
        size++;
    }

     T removeFirst(){
        if(size==0) throw new RuntimeException("리스트가 비었습니다");
        T remove = head.data;
        head = head.next;
        size++;
        return remove;
    }

    T removeLast(){
        if(size==0) throw new RuntimeException("리스트가 비었습니다");
        T remove = tail.data;
        tail = null;
        size--;
        return remove;
    }
}
