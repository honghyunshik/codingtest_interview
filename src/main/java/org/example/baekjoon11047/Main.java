package org.example.baekjoon11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Integer[] coin = new Integer[n];
        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin, Collections.reverseOrder());

        int count = 0;
        for(int num:coin){

            if(target>=num){
                int temp = target/num;
                target -= temp*num;
                count += temp;
            }
            if(target==0) break;
        }
        System.out.println(count);


    }
}
