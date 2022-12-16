package org.example.date20221111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        String first = bf.readLine(); //Int
        String[] input = bf.readLine().split(" ");
        int[] arr = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Integer.parseInt(first.split(" ")[1]);
        System.out.println(tempSum(arr,sum));

    }

    public static int tempSum(int[] arr, int sum){

        int answer = 111000;
        int hab = 0;
        int r = 0;

        for(int i=0;i<arr.length;i++){

            while(hab<sum&&r<arr.length){
                hab+=arr[r];
                r++;
            }

            if(answer>r-i&&hab>=sum){
                answer = r-i;
            }

            hab -= arr[i];
        }
        if(answer==111000) return 0;

        return answer;
    }
}
