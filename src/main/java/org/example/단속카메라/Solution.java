package org.example.단속카메라;

import java.util.*;
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] routes = {{1,4},{2,4},{4,6}};
        System.out.println(sol.solution(routes));
    }
    public int solution(int[][] routes) {

        Arrays.sort(routes,(a,b)->a[0]-b[0]);
        int answer = 1;

        int back = routes[0][1];
        for(int i=1;i<routes.length;i++){

            if(routes[i][0]>back){
                //System.out.println(i + " " + back);
                answer++;
                back = routes[i][1];
            }
        }

        return answer;
    }
}