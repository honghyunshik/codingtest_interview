package org.example.멀쩡한사각형;

class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(6,7));
    }
    public long solution(int w, int h) {
        long answer = w*h;
        if(w==h) return answer-w;

        for(int i=1;i<=h;i++){

            int left = 0, right = 0;
            double one = (double)w/h*(i-1);
            double two = (double)w/h*i;
            if(one%1!=0) left = (int)Math.round(one+0.5);
            else {
                left = (int)one;
                answer++;
            }

            if(two%1!=0) right = (int)Math.round(two+0.5);
            else {
                right = (int)two;
            }

            answer -= right-left+1;
        }
        return answer;
    }
}