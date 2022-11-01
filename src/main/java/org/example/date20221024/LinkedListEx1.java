package org.example.date20221024;


public class LinkedListEx1 {

    public static void main(String[] args){

        LinkedList linkedList = new LinkedList();
        for(char i='a';i<='j';i++){
            Node node = new Node(i);
            linkedList.addNode(node);
        }
        if(linkedList.cl!=null){
            Node cl = linkedList.cl;
            while(cl.next!=linkedList.cl){
                System.out.print("편의점이름 : " + cl.name + " x좌표 : " + cl.x + " y좌표 : " + cl.y);
                cl = cl.next;
            }
        }
    }

}

class Node{

    char name;      //ex)a편의점, b편의점
    Node next;      //연결된 다음 노드
    int x;      //Node의 x좌표
    int y;      //Node의 y좌표
    int distance;       //0,0과의 거리

    Node(char name){
        this.name = name;
        this.x = (int) (Math.random()*100+1);
        this.y = (int) (Math.random()*100+1);
        this.distance = (int) Math.sqrt(x^2+y^2);
        this.next = null;
    }
    Node(){
        this.next = null;
    }

}

class LinkedList{

    Node cl;

    LinkedList(){
        cl = null;
    }

    public void addNode(Node node){

        if(cl==null){
            cl = node;
            cl.next = cl;
        }else{
            Node temp = cl;
            Node prev = node;
            System.out.print("편의점이름 : " + cl.name + " x좌표 : " + cl.x + " y좌표 : " + cl.y + " distance : " + cl.distance);
            System.out.println(temp.next==cl);

            while(temp.next!=cl&&temp.distance<node.distance){
                prev = temp;
                temp = temp.next;
                System.out.println(11);
            }
            System.out.println(" prev : " + prev.next);
            node.next = prev.next;
            prev.next = node;
        }
    }

}
