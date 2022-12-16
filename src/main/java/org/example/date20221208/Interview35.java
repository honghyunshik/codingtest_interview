package org.example.date20221208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//전체 수 n을 입력받아 k개의 조합을 리턴하라
public class Interview35 {

    static int N,K;
    static ArrayList<String[]> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N-K+1;i++){
            dfs(i, "");
        }

        for(String[] arr:answer){
            System.out.print(Arrays.toString(arr) + " ");
        }



    }

    public static void dfs(int num, String prev){

        if(prev.contains(String.valueOf(num))) return;
        prev += num;
        if(prev.length()==K){
            String[] array = prev.split("");
            answer.add(array);
            return;
        }
        for(int i=1;i<N;i++){
            if(num+i<=N) dfs(num+i,prev);
        }

    }
}
