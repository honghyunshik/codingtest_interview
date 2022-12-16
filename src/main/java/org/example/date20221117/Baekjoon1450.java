package org.example.date20221117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon1450 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.parseInt(br.readLine().split(" ")[1]);
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(solution(arr,max));

    }

    public static long solution(int[] array, int max){

        long answer = 0;
        Arrays.sort(array);


        long tempSum = 0;
        int l = 0, r = 1;
        int cnt = 0;

/*
        while(l<array.length&&array[l]<=max){

            tempSum += array[l];
            if(tempSum<=max) {
                cnt++;
            }
            else{
                if(l>0){
                    tempSum -= array[l-1];
                }

                while(tempSum>max){
                    r++;
                    tempSum -= array[l-r];
                }
                if(l>r){
                    answer += Math.pow(2,l-cnt);
                }

            }
            l++;

        }*/

        answer += Math.pow(2,cnt);



        return answer;
    }
}
