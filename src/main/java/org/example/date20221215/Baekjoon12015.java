package org.example.date20221215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon12015 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[num];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void solution(int[] arr){

        int l = 1, r = arr.length-1;
        while(l<r){

            int mid = (l+r)/2;
            
        }

    }
}
