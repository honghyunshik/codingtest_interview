package org.example.baekjoon2776;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        for(int i=0;i<num;i++){
            int su1 = Integer.parseInt(br.readLine());
            int[] arr1 = new int[su1];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<su1;j++){
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            int su2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[] arr2 = new int[su2];
            for(int j=0;j<su1;j++){
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(getAns(arr1,arr2).toString());
        }
    }

    public static StringBuilder getAns(int[] arr1, int[] arr2){
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr1);
        for(int i=0;i<arr2.length;i++){
            int l=0,r=arr2.length-1;
            boolean check = false;
            while(l<=r){
                int mid = (l+r)/2;
                if(arr1[mid]>arr2[i]){
                    r = mid-1;
                }else if(arr1[mid]<arr2[i]){
                    l = mid+1;
                }else{
                    sb.append(1 + "\n");
                    check = true;
                    break;
                }
            }
            if(!check) sb.append(0 + "\n");
        }



        return sb;
    }
}
