package org.example.date20221013;

import java.util.Deque;
import java.util.LinkedList;

//파이썬 알고리즘 인터뷰 책 24번 문제 - 스택을 이용한 큐 구현(255p)
public class Interview24 {
    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.pop();
    }
}

class MyQueue{

    Deque<Integer> deque;

    MyQueue(){
        deque = new LinkedList<>();
    }

    //요소 x를 큐 마지막에 삽입한다
    public void push(int x){
        deque.push(x);
    }

    //stack 은 push와 pop

    //큐 처음에 있는 요소를 제거한다
    public int pop(){
        Deque<Integer> newdeq = new LinkedList<>();
        int size = deque.size();
        System.out.println(deque);
        for(int i=0;i<size;i++){
            System.out.println(deque.poll());
        }
        System.out.println(deque);
        return 1;

    }

    //큐 처음에 있는 요소를 조회한다
    public int peek(){
        return 1;
    }

    //큐가 비어 있는지 여부를 리턴한다
    public Boolean empty(){
        return deque.isEmpty();
    }


}
