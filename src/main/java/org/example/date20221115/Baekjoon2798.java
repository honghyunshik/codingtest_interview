package org.example.date20221115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine().split(" ")[1]);
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(blackjack(arr,sum));
    }

    public static int blackjack(int[] arr,int sum){

        int answer = Integer.MIN_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int nowSum = sum-arr[i];
            int l = i+1;
            int r = arr.length-1;
            while(l<r){
                if(Math.abs(sum-answer)>Math.abs(nowSum-arr[l]-arr[r])&&sum>arr[l] + arr[r] + arr[i]){

                    answer = arr[l] + arr[r] + arr[i];
                }
                if(nowSum-arr[l]-arr[r]<0){
                    r--;
                }else if(nowSum-arr[l]-arr[r]>0){
                    l++;
                }else{
                    return sum;
                }
            }
        }

        return answer;
    }
}
