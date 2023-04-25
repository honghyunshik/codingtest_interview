package org.example.야근지수;

import java.util.*;
class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] works = {2,1,2};
        System.out.println(solution.solution(1,works));
    }
    public long solution(int n, int[] works) {
        long answer = 0;

        Arrays.sort(works);

        int l=works.length-1;
        int r = l;
        while(n>0&&works[0]>0){

            while(r>0&&works[r]==works[r-1]){
                r--;
            }
            if(r>0) r--;
            System.out.println("n : " + n + " " + Arrays.toString(works) + " r : " + r);

            if(r==0){

                int last = n%(l+1);
                for(int i=r;i<=l;i++){

                    works[i] -= n/(l+1);
                    if(works[i]>0&&last>0){
                        works[i]--;
                        last--;
                    }else if(works[i]<0) works[i] = 0;
                }
                n=0;
            }
            else if(n>=(l-r)*(works[l]-works[r])){

                n-=(l-r)*(works[l]-works[r]);

                for(int i=r+1;i<=l;i++){
                    works[i] = works[r];
                }

            }else{

                int last = n%(l-r);
                for(int i=r+1;i<=l;i++){
                    works[i] -= n/(l-r);
                    if(last>0){
                        works[i]--;
                        last--;
                    }
                }
                n = 0;
            }
        }
        System.out.println(Arrays.toString(works));
        return answer;
    }
}