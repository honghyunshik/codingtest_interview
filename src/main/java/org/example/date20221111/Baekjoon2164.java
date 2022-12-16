package org.example.date20221111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baekjoon2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int

        System.out.println(card(num));
    }

    public static int card(int num){

        Deque<Integer> deque = new LinkedList<>();
        for(int i=num;i>=1;i--){
            deque.push(i);
        }

        while(deque.size()>1){
            deque.pop();
            int top = deque.peek();
            deque.addLast(top);
            deque.pop();
        }

        return deque.pop();

    }
}
