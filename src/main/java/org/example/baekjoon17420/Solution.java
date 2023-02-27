package org.example.baekjoon17420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Gift[] gift = new Gift[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<num;i++){
            gift[i] = new Gift(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<num;i++){
            gift[i].will = Integer.parseInt(st.nextToken());
        }
        long answer = 0;

        Arrays.sort(gift);
        long max = 0;
        int prevWill = 0;
        long prevTotal = 0;
        for(Gift g:gift){


            //값이 달라지면 이전 최댓값 초기화
            if(prevWill!=g.will){
                max = prevTotal;
            }

            //몇번을 연장해야 하느냐?
            long delayCnt = (g.will-g.left)/30;
            if((g.will-g.left)%30>0) delayCnt++;
            delayCnt = Math.max(0,delayCnt);
            long delayTotal = delayCnt*30 + g.left;
            if(delayTotal<=max){
                delayCnt =  (max - g.left) / 30;
                if ((max-g.left)%30 > 0) delayCnt++;
                delayCnt = Math.max(0,delayCnt);
                delayTotal = delayCnt * 30 + g.left;
            }


            if(prevTotal<delayTotal){
                prevTotal = delayTotal;
            }

            prevWill = g.will;


            answer += delayCnt;
        }

        System.out.println(answer);


    }
}

class Gift implements Comparable<Gift>{
    int left,will;
    Gift(int left){
        this.left = left;
    }

    @Override
    public int compareTo(Gift o) {
        if(this.will==o.will) return this.left-o.left;
        return this.will-o.will;
    }
}
