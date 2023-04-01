package org.sort;

public class QueueWithLinkedList {

    public static void main(String[] args){
        QueueWithLinkedList queueWithLinkedList = new QueueWithLinkedList();
        queueWithLinkedList.add(1);
        queueWithLinkedList.add(2);
        queueWithLinkedList.add(3);
        System.out.println(queueWithLinkedList.poll());
        System.out.println(queueWithLinkedList.poll());
        System.out.println(queueWithLinkedList.poll());
        System.out.println(queueWithLinkedList.poll());
    }
    Node root;
    int size;

    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    int poll(){

        if(size==0) throw new RuntimeException("큐가 비었습니다");
        else{
            int poll = root.data;
            root = root.next;
            size--;
            return poll;
        }
    }

    void add(int n){
        if(size==0) {
            root = new Node(n);
        }
        else{
            Node node = root;
            Node back = node;
            while(node!=null){
                back = node;
                node = node.next;
            }
            back.next = new Node(n);
        }
        size++;
        ;
    }


}
