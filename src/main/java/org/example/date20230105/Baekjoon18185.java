package org.example.date20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon18185 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] ramyeon = new int[N];
        for(int i=0;i<N;i++){
            ramyeon[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(greedy(ramyeon));
    }

    public static long greedy(int[] array){

        long money = 0;

        for(int i=0;i<array.length;i++){

            int min = Integer.MAX_VALUE;
            if(i+2<array.length){
                if(array[i+1]>array[i+2]){
                    min = Math.min(array[i],array[i+1]-array[i+2]);
                    money += min*5;
                    array[i] -= min;
                    array[i+1] -= min;
                }
                min = Integer.MAX_VALUE;
                min = Math.min(array[i],min);
                min = Math.min(array[i+1],min);
                min = Math.min(array[i+2],min);
                money += min*7;
                array[i] -= min;
                array[i+1] -= min;
                array[i+2] -= min;
            }
            if(i+1<array.length){
                min = Integer.MAX_VALUE;
                min = Math.min(array[i+1],min);
                min = Math.min(array[i],min);
                money += min*5;
                array[i] -= min;
                array[i+1] -= min;
            }
            if(array[i]>0){
                money+=array[i]*3;
            }
        }

        return money;
    }
}
