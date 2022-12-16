package org.example.date20221204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] array = new int[num];

        for(int i=0;i<num;i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        System.out.println(solution(array,count));


    }

    public static long solution(int[] array, long count){

        long l = 1, r = array[array.length-1]-array[0]+1;

        while(l<r){

            long mid = (l+r)/2;
            long nowCount = counting(array,mid);

            //distance를 늘여야 함
            if(nowCount>=count){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        return r-1;
    }

    public static long counting(int[] array, long distance){

        int lastLocate = 0;
        long count = 1;

        for(int i=1;i<array.length;i++){
            if(array[i]-array[lastLocate]>=distance){
                count++;
                lastLocate = i;
            }
        }

        return count;
    }
}
