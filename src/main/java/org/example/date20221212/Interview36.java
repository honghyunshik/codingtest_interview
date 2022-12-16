package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//숫자 집합 candidates를 조합하여 합이 target이 되는 원소를 나열하라. 각 원소는 중복으로 나열이 가능하다.
public class Interview36 {

    static int[] candidates;
    static int target;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        candidates = new int[input.length];

        for(int i=0;i<input.length;i++){
            candidates[i] = Integer.parseInt(input[i]);
        }
        target = Integer.parseInt(br.readLine());

        for(int i=0;i<candidates.length;i++){
            dfs(i,0, "");
        }

    }

    public static void dfs(int index, int prev, String str){

        prev += candidates[index];
        str += candidates[index];

        if(prev>target) return;
        else if(prev==target){
            System.out.println(Arrays.toString(str.split("")));
        }else{
            for(int i=index;i<candidates.length;i++){
                dfs(i,prev,str);
            }
        }
    }


}

