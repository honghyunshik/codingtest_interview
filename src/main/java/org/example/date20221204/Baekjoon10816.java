package org.example.date20221204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];
        String[] line = br.readLine().split(" ");
        for(int i=0;i<num;i++){
            array[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(array);
        num = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num;i++){
            sb.append(solution(array, Integer.parseInt(line[i])) + " ");
        }
        System.out.println(sb.toString());
    }

    public static int solution(int[] array, int num){

        int left = lowerBound(array, num);
        int right = upperBound(array,num);
        if(array[left]==num&&array[right]==num){
            return right-left+1;
        }else{
            return right-left;
        }




    }

    //target보다 크거나 같은 첫번째 원소를 반환
    public static int lowerBound(int[] array, int num){

        int l = 0, r = array.length-1;

        while(l<r){

            int mid = (l+r)/2;
            if(array[mid]>=num){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r;

    }

    //target보다 큰 첫번째 원소를 반환
    public static int upperBound(int[] array, int num){

        int l = 0, r = array.length-1;

        while(l<r){

            int mid = (l+r)/2;
            if(array[mid]<=num){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return r;
    }
}
