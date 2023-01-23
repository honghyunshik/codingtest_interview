package org.example.kakao4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        Solution sol = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        //산봉우리 수
        int[][] paths = new int[n+1][n+1];      //등산로 정보

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            try{
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                paths[start][end] = time;
                paths[end][start] = time;
            }catch(Exception e){
                break;
            }
        }

        String[] gates_str = br.readLine().split(" ");
        int[] gates = new int[gates_str.length];        //출입구 정보
        for(int i=0;i<gates_str.length;i++){
            gates[i] = Integer.parseInt(gates_str[i]);
        }

        String[] summits_str = br.readLine().split(" ");
        int[] summits = new int[gates_str.length];        //산봉우리 정보(오른차순 정렬)
        for(int i=0;i<gates_str.length;i++){
            gates[i] = Integer.parseInt(gates_str[i]);
        }
        Arrays.sort(summits);       //산봉우리 오름차순 정렬


        int[] answer = sol.solution(n,paths,gates,summits);
        System.out.println(Arrays.toString(answer));



    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        //n은 지점 수
        //paths는 등산로 정보를 담은 2차원 정수배열
        //gates는 출입구들의 번호가 담긴 정수배열
        //산봉우리들의 번호가 담긴 정수배열 summits

        int intensity = Integer.MAX_VALUE;      //휴식 없이 이동한 시간
        int[] answer = new int[2];


        return answer;
    }


}
