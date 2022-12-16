package org.example.date20221204;

import javafx.beans.property.IntegerProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] array = new int[num];

        st = new StringTokenizer(br.readLine()," ");
        int max = Integer.MIN_VALUE;

        for(int i=0;i<num;i++){
            array[i] = Integer.parseInt(st.nextToken());
            max = Math.max(array[i],max);
        }
        System.out.println(solution(array,N,max));


    }

    public static long solution(int[] array, long N, long max){

        long l = 0, r = max;

        while(l<r){

            long mid = (l+r)/2;
            long sum = 0;
            for(int i:array){
                if(i>mid) sum += i-mid;
            }

            //sum을 줄여도 됨
            if(sum>=N){
                l = mid+1;
            }else{
                r = mid;
            }

        }


        return r-1;
    }
}
