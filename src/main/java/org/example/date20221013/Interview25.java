package org.example.date20221013;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


//파이썬 알고리즘 인터뷰 책 25번 문제 - 원형 큐를 디자인하라(259p)
public class Interview25 {
    public static void main(String[] args){
        MyCircularQueue circularQueue = new MyCircularQueue(5);
        circularQueue.enQueue(10);
        circularQueue.enQueue(20);
        circularQueue.enQueue(30);
        circularQueue.enQueue(40);
        //circularQueue.printArr();
        //System.out.println(circularQueue.Rear());
        //System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        //circularQueue.printArr();
        System.out.println(circularQueue.enQueue(50));
        System.out.println(circularQueue.enQueue(60));
        circularQueue.printArr();
        //System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Front());


    }
}

class MyCircularQueue{

    Integer[] arr;
    int front;      //큐의 가장 앞 index
    int back;       //큐의 가장 끝 index

    MyCircularQueue(int size){
        arr = new Integer[size];
        front = 0;
        back = 0;
    }

    //원형 큐에 요소를 삽입, 성공시 true 반환
    public boolean enQueue(int num){

        if(isFull()){
            return false;
        }

        if(!isEmpty()){
            if(back==arr.length-1){
                back = 0;
            }else{
                back++;
            }
        }

        System.out.println("front : " + front + " back : " + back);

        arr[back] = num;


        return true;
    }

    //원형 큐의 요소를 삭제, 성공시 true 반환
    public boolean deQueue(){

        if(isEmpty()){
            return false;
        }

        arr[front] = null;

        if(front==arr.length-1){
            front = 0;
        }else{
            front++;
        }


        System.out.println("front : " + front + " back : " + back);


        return true;
    }

    //큐에서 마지막 요소를 가져온다. 큐가 비어있다면 -1을 반환
    public int Rear(){

        if(arr[back]!=null){
            return arr[back];
        }
        return -1;
    }

    //큐가 가득 차 있는지 확인
    public boolean isFull(){
        for(Integer num:arr){
            if(num==null){
                return false;
            }
        }
        return true;
    }

    //큐가 비어 있는지 확인
    public boolean isEmpty(){
        if(front==back&&arr[front]==null){
            return true;
        }
        return false;
    }

    //큐에서 처음 요소를 가져온다. 큐가 비어있다면 -1을 반환
    public int Front(){
        if(arr[front]!=null){
            return arr[front];
        }
        return -1;
    }

    public void printArr(){
        for(Integer num:arr){
            System.out.print(num + " ");
        }
        System.out.println("");
    }


}


