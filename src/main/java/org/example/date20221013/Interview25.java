package org.example.date20221013;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Interview25 {
    public static void main(String[] args){

        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pollLast();
        System.out.println(stack);
    }
}
