package org.sort;

class Solution {

    public static void main(String[] args){
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        Solution sol = new Solution();
        System.out.println(sol.solution(sequence));
    }
    public long solution(int[] sequence) {

        int size = sequence.length;
        int l = 0, r = 0;       //l은 +로 시작, r은 -로 시작
        long plusStart = 0;
        long minusStart = 0;
        long answer = 0;
        while(l<size&&r<size){
            int tempL = l;
            int tempR = r;
            while(l<size&&plusStart>=0){
                //짝수면 +
                if((l-tempL)%2==0) plusStart += sequence[l++];
                //홀수면 -
                else plusStart -= sequence[l++];
                if(answer<plusStart) {
                    System.out.println("plus : " + tempL + " " + l);
                    answer = plusStart;
                }
            }
            while(r<size&&minusStart>=0){
                //짝수면 -
                if((r-tempR)%2==0) minusStart -= sequence[r++];
                    //홀수면 +
                else minusStart += sequence[r++];
                if(answer<minusStart){
                    System.out.println("minus : " + tempR + " " + r);
                    answer = minusStart;
                }
            }
            minusStart = 0;
            plusStart = 0;

        }
        return answer;
    }
}