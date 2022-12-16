package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon1450 {

    static ArrayList<Integer> first,second;
    static int[] array1, array2;
    static int C;
    static int index = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());       //물건의 개수
        C = Integer.parseInt(st.nextToken());       //최대 담을수 있는 무게

        String[] input = br.readLine().split(" ");
        array1 = new int[input.length%2==0?input.length/2:input.length/2+1];
        array2 = new int[input.length/2];
        for(int i=0;i<array1.length;i++){
            array1[i] = Integer.parseInt(input[i]);
        }
        for(int i=array1.length;i<input.length;i++){
            array2[i-array1.length] = Integer.parseInt(input[i]);
        }
        first = new ArrayList<>();
        second = new ArrayList<>();


        System.out.println(binary());

    }

    public static int binary(){

        recursionA(0,0);
        recursionB(0,0);

        Collections.sort(first);
        Collections.sort(second);

        int answer = 0;

        for(int i=0;i<first.size();i++){

            index = binarySearch(0,second.size()-1,first.get(i));
            answer += index;

        }

        return answer;
    }

    //upper bound
    public static int binarySearch(int l,int r, int a){

        while(l<r){

            int mid = (l+r)/2;
            int target = C-a;
            if(second.get(mid)<=target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        if(second.get(r)<=C-a) return r+1;
        return r;
    }

    public static void recursionA(int index, int sum){

        if(sum>C) return;

        if(index==array1.length) {
            first.add(sum);
            return;
        }

        recursionA(index+1,sum);
        recursionA(index+1,sum + array1[index]);


    }
    public static void recursionB(int index, int sum){

        if(sum>C) return;

        if(index==array2.length) {

            second.add(sum);
            return;
        }

        recursionB(index+1,sum);
        recursionB(index+1,sum + array2[index]);


    }
}
