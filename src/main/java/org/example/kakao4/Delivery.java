package org.example.kakao4;

import java.util.*;
public class Delivery {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int p = n-1;
        while(p>=0){

            //배달할 것도, 수거할 것도 없다면 p를 감소
            while(p>=0&&deliveries[p]==0&&pickups[p]==0){
                p--;
            }

            int go_cap = cap;
            int back_cap = cap;
            answer += (p+1)*2;

            for(int k=p;k>=0;k--){

                if(go_cap<=0&&back_cap<=0) break;
                if(go_cap>=deliveries[k]&&back_cap>=pickups[k]) p--;
                if(go_cap>=deliveries[k]){
                    go_cap -= deliveries[k];
                    deliveries[k] = 0;
                }else{
                    deliveries[k] -= go_cap;
                    go_cap = 0;
                }
                if(back_cap>=pickups[k]){

                    back_cap -= pickups[k];
                    pickups[k] = 0;
                }else{
                    pickups[k] -= back_cap;
                    back_cap = 0;
                }

            }

        }
        return answer;
    }
}
