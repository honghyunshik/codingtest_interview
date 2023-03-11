package org.example;

import org.example.kakao3.Solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2512 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n];
        int max = 0;

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }

        int target = Integer.parseInt(br.readLine());
        System.out.println(getMax(arr,max,target));
    }

    public static int getMax(int[] arr,int max, int target){

        int l=0 , r = max, temp = 0;
        while(l<r){
            int mid = (l+r)/2;
            temp = 0;
            for(int i=0;i<arr.length;i++){
                temp += Math.min(arr[i],mid);
            }
            if(temp>target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(temp<=target&&max==r) return r;
        return r-1;
    }
}
