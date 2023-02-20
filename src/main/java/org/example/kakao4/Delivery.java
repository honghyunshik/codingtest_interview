package org.example.kakao4;

import java.util.*;

class Delivery {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int p = n-1;
        Stack<Integer> go = new Stack();
        Stack<Integer> back = new Stack();
        for(int i:deliveries){
            go.push(i);
        }
        for(int i:pickups){
            back.push(i);
        }
        while(!go.isEmpty()&&go.peek()==0){
            go.pop();
        }
        while(!back.isEmpty()&&back.peek()==0){
            back.pop();
        }
        answer += Math.max(go.size(),back.size())*2;
        while(!go.isEmpty()||!back.isEmpty()){
            int go_temp = cap;
            int back_temp = cap;
            while(!go.isEmpty()&&go_temp>=0){
                int go_now = go.pop();
                go_temp -= go_now;
                if(go_temp<0) go.push(-go_temp);
            }
            while(!back.isEmpty()&&back_temp>=0){
                int back_now = back.pop();
                back_temp -= back_now;
                if(back_temp<0) back.push(-back_temp);
            }
            answer += Math.max(go.size(),back.size())*2;
            //System.out.println(go.size() + " " + back.size());
        }
        return answer;
    }
}
