package org.example.두원사이정수쌍;

import java.util.*;
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        //System.out.println(sol.solution(2,4));
        //System.out.println(sol.solution(9,20));
        //System.out.println(sol.solution(999999,1000000));
        System.out.println(sol.solution(999999,1000000));
    }

    public long solution(int r1, int r2) {

        long answer = 0;
        long r2Mul = (long)r2*r2;
        long r1Mul = (long)r1*r1;

        for(int i=1;i<=r2;i++){

            long mulI = (long)i*i;

            double top = Math.sqrt(r2Mul-mulI);
            double bottom = Math.sqrt(r1Mul-mulI);

            //바깥 원은 내림해줌
            long heightR2 = (long)Math.round(top-0.5);

            //안의 원은 정수면 냅두고 정수아니면 올림해줌
            long heightR1 = 0;
            if(bottom%1==0) heightR1 = (long)Math.round(bottom);
            else heightR1 = (long)(Math.round(bottom+0.5));

            //System.out.println(heightR2 + " " + heightR1 + " " + r2Mul);
            answer += heightR2-heightR1+1;
        }
        return answer*4;
    }
}