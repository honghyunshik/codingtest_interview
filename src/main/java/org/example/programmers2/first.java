package org.example.programmers2;

import java.util.*;
class first {
    static int count = 0;
    static int[] answer;

    public static void main(String[] args){
        first f = new first();
        f.solution(3,5);
        System.out.println(Arrays.toString(answer));
    }
    public int[] solution(int n, long k) {
        answer = new int[n];
        boolean[] visited = new boolean[n+1];

        int[] ans = new int[n];
        makeArray(visited,0,k);
        return answer;
    }

    public void makeArray(boolean[] visited,  int idx,long k){

        if(idx==answer.length){
            return;
        }

        int multiple = 1;
        for(int i=2;i<=answer.length-idx-1;i++){
            multiple *= i;
        }

        //System.out.println("multiple : " + multiple + " idx : " + idx);
        int cnt = 1;
        for(int i=1;i<=answer.length;i++){
            if(!visited[i]){
                //System.out.println("cnt : " + cnt + " multiple  :" + multiple + " k : " + k + " " + (multiple*(cnt-1) + " " + (multiple*(cnt))));
                if(multiple*(cnt-1)+1<=k&&multiple*cnt+1>k){
                    visited[i] = true;
                    answer[idx] = i;
                    makeArray(visited,idx+1,k-multiple*(cnt-1));
                }
                cnt++;
            }

        }
    }

    /*
    public void bruteforce(boolean[] visited, int[] ans, int idx,long k){

        //System.out.println(Arrays.toString(visited) + "   " + idx);
        if(idx==visited.length-1){

            count++;
            if(count==k){
                for(int i=0;i<answer.length;i++){
                    answer[i] = ans[i];
                }
            }
            return;
        }
        for(int i=1;i<visited.length;i++){
            if(!visited[i]){
                visited[i] = true;
                ans[idx] = i;
                bruteforce(visited, ans, idx+1,k);
                visited[i] = false;
            }
        }
    }
    */
}