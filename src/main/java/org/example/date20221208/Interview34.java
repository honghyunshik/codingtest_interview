package org.example.date20221208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//서로 다른 정수를 입력받아 가능한 모든 순열을 리턴하라
public class Interview34 {

    static ArrayList<String[]> answer = new ArrayList<>();
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        array = new int[input.length];

        for(int i=0;i<input.length;i++){
            array[i] = Integer.parseInt(input[i]);
        }

        for(int i=0;i<array.length;i++){
            dfs(i, "");
        }

        for(int i=0;i<answer.size();i++){
            System.out.println(Arrays.toString(answer.get(i)));
        }


    }

    public static void dfs(int num,  String prev){

        if(prev.contains(String.valueOf(array[num]))) return;


        prev += array[num];
        if(prev.length()==array.length){
            String[] array = prev.split("");
            answer.add(array);
            return;
        }


        for(int i=1;i<array.length;i++){
            if(num+i>=0&&num+i<array.length) dfs(num+i,prev);
            if(num-i>=0&&num-i<array.length) dfs(num-i,prev);
        }
    }
}
