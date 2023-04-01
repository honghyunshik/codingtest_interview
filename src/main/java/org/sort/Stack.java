package org.sort;

public class Stack {

    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    int[] stack = new int[100];
    int idx = -1;

    void push(int n){
        if(idx<stack.length){
            stack[++idx] = n;
        }else{
            throw new RuntimeException("스택이 꽉 찼습니다");
        }
    }

    int pop(){
        if(idx>=0){
            return stack[idx--];
        }else{
            throw new RuntimeException("스택이 비었습니다");
        }
    }

    int getSize(){
        return idx+1;
    }
}
