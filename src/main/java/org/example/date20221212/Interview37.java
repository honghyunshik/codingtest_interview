package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//모든 부분 집합을 리턴하라
public class Interview37 {

    static int[] nums;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        nums = new int[input.length];

        for(int i=0;i<input.length;i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        dfs(0,true,"");
        dfs(0,false,"");


    }

    public static void dfs(int index, boolean input, String str){

        if(input) str += nums[index];
        if(index==nums.length-1) {
            System.out.println(Arrays.toString(str.split("")));
            return;
        }

        dfs(index+1,true,str);
        dfs(index+1,false,str);
    }
}
