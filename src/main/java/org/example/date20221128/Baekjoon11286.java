package org.example.date20221128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon11286 {

    public static void main(String[] args) throws IOException {


        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1>o2?1:-1;
                }else if(Math.abs(o1)>Math.abs(o2)){
                    return 1;
                }
                return 1;
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0){
                if(!pq.isEmpty()) System.out.println(pq.poll());
                else System.out.println(0);
            }else{
                pq.add(input);
            }
        }

    }



}
