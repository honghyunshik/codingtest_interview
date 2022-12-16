package org.example.date20221102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class Baekjoon17299 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int num = Integer.parseInt(bf.readLine()); //Int
        String[] strInput = bf.readLine().split(" ");
        int[] input = Stream.of(strInput)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(getNFG(input));
    }

    public static String getNFG(int[] arr){

        int[] list = new int[arr.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            if(map.containsKey(i)){
                int num = map.get(i);
                map.put(i,++num);
            }else{
                map.put(i,1);
            }
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){

            while(stack.size()>0&&map.get(arr[stack.peek()])<map.get(arr[i])){
                list[stack.pop()] = arr[i];
            }
            stack.add(i);
        }

        while(stack.size()>0){
            list[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i:list){
            sb.append(i + " ");
        }


        return sb.toString();
    }
}
