package org.example.date20221013;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//파이썬 알고리즘 인터뷰 책 23번 문제 - 큐를 이용한 스택 구현(255p)
public class Interview23 {
    public static void main(String[] args){
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.deque);
        stack.pop();
        System.out.println(stack.deque);
        stack.top();
        stack.pop();
        stack.empty();

    }
}

class MyStack{

    Deque<Integer> deque;

    MyStack(){
        deque = new LinkedList<>();
    }
    //요소 x를 스택에 삽입한다
    public void push(int input){
        deque.add(input);
        for(int i=0;i<deque.size()-1;i++){
            deque.add(deque.pop());
        }
    }

    //스택의 첫 번째 요소를 가져온다
    public int top(){
        return deque.getFirst();
    }

    //스택의 첫 번째 요소를 삭제한다
    public int pop(){
        return deque.pop();
    }

    //스택이 비어있는지 여부를 리턴한다
    public Boolean empty(){
        return deque.isEmpty();
    }

}
