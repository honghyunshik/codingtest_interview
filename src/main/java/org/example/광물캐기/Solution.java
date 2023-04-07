package org.example.광물캐기;

class Solution {
    //곡괭이 각각 0~5개 보유
    //각 곡괭이는 광물 5캐 맨 후에 더이상 사용불가
    //picks 0 : 다이아   1: 철   2 : 돌
    static int[][] D = {{1,1,1},{5,1,1},{25,5,1}};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] picks = {1,3,2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        sol.solution(picks,minerals);
        System.out.println(answer);
    }
    public int solution(int[] picks, String[] minerals) {

        bruteForce(picks,minerals,0,0);
        return answer;
    }
    void bruteForce(int[] picks, String[] minerals, int idx, int piro){

        System.out.println(idx + " " + piro);
        if(piro>=answer) return;        //누적 piro가 더 크면 종료
        if(idx>=minerals.length){
            answer = Math.min(answer,piro);
            return;
        }
        for(int i=0;i<picks.length;i++){
            if(picks[i]==0) continue;
            int temp_piro = piro;
            for(int j=idx;j<Math.min(minerals.length,idx+5);j++){
                int num = 0;
                if(minerals[j].equals("diamond")) num = 0;
                else if(minerals[j].equals("iron")) num = 1;
                else num = 2;
                temp_piro += D[i][num];
            }
            picks[i]--;
            bruteForce(picks,minerals,idx+5,temp_piro);
            picks[i]++;
        }
    }
}