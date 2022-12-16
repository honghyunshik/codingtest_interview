package org.example.date20221212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//0을 완료하기 위해서는 1을 끝내야 한다는 것을 [0,1] 쌍으로 표현하는 n개의 코스가 있다.
//코스 개수 n과 이 쌍들을 입력으로 받았을 때 모든 코스가 완료 가능한지 판별하라.
public class Interview39 {

    static boolean[] check;
    static int[][] array;
    static boolean ans = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        array = new int[count][2];
        check = new boolean[num];
        for(int i=0;i<count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int[] temp = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            check[temp[0]] = true;
            array[i] = temp;
        }

        for(int i=0;i<num;i++){
            dfs(i,i,true);
        }
        System.out.println(ans);

    }

    public static void dfs(int num, int startNum, boolean isFirst){

        if(num==startNum&&!isFirst){
            ans = false;
            return;
        }
        if(check[num]){
            for(int[] arr:array){
                if(arr[0]==num) {
                    dfs(arr[1],startNum,false);
                }
            }
        }


    }
}
