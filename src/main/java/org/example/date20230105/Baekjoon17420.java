package org.example.date20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon17420 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        Gift[] giftList = new Gift[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            giftList[i] = new Gift(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            giftList[i].willDay = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(giftList);

        System.out.println(minNum(giftList));


    }

    public static long minNum(Gift[] giftList){

        int count = 0;
        //1. 이전 선물의 남아있는 일수보다 많이 남아있어야 함

        for(Gift gift:giftList){

        }



        return count;
    }
}



class Gift implements Comparable<Gift>{

    int lastDay, willDay;
    Gift(int lastDay){
        this.lastDay = lastDay;
    }
    @Override
    public int compareTo(Gift o) {
        return this.willDay-o.willDay;
    }
}
