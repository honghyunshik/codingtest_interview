package org.example.baekjoon15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] array = new int[row][col];
        for(int i=0;i<row;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<col;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}

class Solution{

    int minWidth(int[][] array){

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;i++){
                if(array[i][j]!=6&&array[i][j]!=0&&array[i][j]!=-1){
                    ArrayList<int[]> forBefore = new ArrayList<>();
                    backTracking(forBefore);

                }
            }
        }

        return -1;
    }

    void backTracking(ArrayList<int[]> forBefore){

    }

}


