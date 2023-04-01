package org.sort;

public class LinkedList<T> {

    private class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
    }
    Node head,tail;
    int size;

    void addFirst(T input){

        if(size==0){
            head = new Node(input);
            tail = head;
        }else{
            Node newNode = new Node(input);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void addLast(T input){

        if(size==0){
            addFirst(input);
        }else{
            Node newNode = new Node(input);
            tail.next = newNode;
            tail = newNode;
            size++;
        }

    }

    public void add(int k, T input){

        if(k==0) addFirst(input);
        else{
            Node newNode = new Node(input);
            Node temp = head;
            for(int i=0;i<k-1;i++){
                temp = temp.next;
            }
            Node next = temp.next;
            temp.next=newNode;
            newNode.next = next;
            size++;
        }
    }

    public T removeFirst(){
        if(size==0) throw new RuntimeException("리스트가 비었습니다");
        else{
            T remove = head.data;
            head = head.next;
            size--;
            return remove;
        }
    }



}
