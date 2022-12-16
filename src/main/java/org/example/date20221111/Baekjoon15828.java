package org.example.date20221111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Baekjoon15828 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int size = Integer.parseInt(bf.readLine()); //Int

        Deque<Integer> deque = new LinkedList<>();


        while(true){
            int input = Integer.parseInt(bf.readLine());
            if(input==-1){
                break;
            }
            router(size,input,deque);
        }
        if(deque.isEmpty()) {
            System.out.println("empty");
        }else{
            StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()){
                sb.append(deque.remove() + " ");
            }
            System.out.println(sb.toString());
        }

    }

    public static void router(int size, int input, Deque<Integer> deque) throws IOException {

        if(input==0){

            if(!deque.isEmpty()) deque.remove();
        }else{

            if(deque.size()<size) deque.add(input);
        }

    }
}
