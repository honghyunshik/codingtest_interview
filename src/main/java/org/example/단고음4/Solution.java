package org.example.단고음4;

import java.util.*;
class Solution {

    //3 3 3 1 1 1
    //3의 개수가 x 개이면 1의 개수는 x*2개
    //3이 현재 y가 나왔으면 1은 최대 y*2까지 나올 수 있다


    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(150));
    }
    static int answer = 0;
    public int solution(int n) {

        //dfs(0,0,1,n);
        int cnt3 = get3(n);
        int cnt1 = cnt3*2;
        if(Math.pow(3,cnt3) + cnt1>n) return 0;
        dfs(0,0,cnt3,1,"",n);


        return answer;
    }

    private int get3(int n){

        long k = 6;
        int cnt = 1;
        while(n>=k){
            k*=3;
            cnt++;
        }
        return cnt;
    }

    private void dfs(int cnt3, int cnt1, int max3, long sum, String str,int target){

        if(sum>target) return;
        if(cnt3>max3) return;

        if(sum==target&&cnt3*2==cnt1){
            answer++;
            return;
        }

        if(cnt3==max3&&cnt1==cnt3*2) return;
        System.out.println("cnt3 : " + cnt3 + " cnt1 : " + cnt1 + " sum : " + sum + " str : " + str);

        dfs(cnt3+1,cnt1,max3,sum*3,str+3,target);
        if(cnt3*2>=cnt1+1) dfs(cnt3,cnt1+1,max3, sum+1,str+1,target);

    }
}