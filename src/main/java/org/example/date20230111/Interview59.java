package org.example.date20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Interview59 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] array = new int[4][2];
        for(int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            array[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }

        ArrayList<int[]> list = merge(array);
        for(int[] arr:list){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static ArrayList<int[]> merge(int[][] array){

        Arrays.sort(array,(a,b)->a[0]-b[0]);
        ArrayList<int[]> answer = new ArrayList<>();
        int prevL = array[0][0], prevR = array[0][1];

        for(int idx=1;idx<array.length;idx++){
            if(array[idx][0]<prevR){
                prevR = Math.max(prevR, array[idx][1]);
            }else{
                answer.add(new int[]{prevL,prevR});
                prevL = array[idx][0];
                prevR = array[idx][1];
            }
        }
        answer.add(new int[]{prevL,prevR});


        return answer;
    }
}
