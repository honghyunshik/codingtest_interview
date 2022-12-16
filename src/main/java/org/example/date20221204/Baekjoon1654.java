package org.example.date20221204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int count = Integer.parseInt(line[0]);
        int num = Integer.parseInt(line[1]);
        int[] array = new int[count];
        long max = Integer.MIN_VALUE;
        for(int i=0;i<count;i++){
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(array[i],max);
        }
        System.out.println(solution(array,num,max));


    }

    public static long solution(int[] array, long num, long max){

        long l = 0, r = max+1;

        while(l<r){
            long sum = 0;
            long mid = (l+r)/2;
            for(int i:array){
                sum += i/mid;
            }
            //수를 줄여야됨
            if(sum<num){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r-1;


    }
}
