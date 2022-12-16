package org.example.date20221111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int

        String[] input = bf.readLine().split(" ");
        int[] arr = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Integer.parseInt(bf.readLine());

        System.out.println(getSum(arr,sum));



    }

    public static int getSum(int[] arr, int sum){

        int answer = 0;
        int l=0, r=arr.length-1;
        Arrays.sort(arr);

        while(l<r){
            if(arr[l]+arr[r]<sum){
                l++;
            }else if(arr[l]+arr[r]>sum){
                r--;
            }else{
                answer++;
                l++;
                r--;
            }
        }

        return answer;
    }
}
