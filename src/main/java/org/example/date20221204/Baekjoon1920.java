package org.example.date20221204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1920 {

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
        for(int i=0;i<num;i++){
            System.out.println(solution(array, Integer.parseInt(line[i])));
        }




    }

    public static int solution(int[] array, int num){

        int l = 0, r = array.length-1;

        while(l<=r){

            int mid = (l+r)/2;
            if(array[mid]==num) return 1;
            else if(array[mid]<num){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }


        return 0;
    }
}
