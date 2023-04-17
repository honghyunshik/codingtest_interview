package org.example.옮기기110;

class Solution {

    public static void main(String[] args){

        Solution sol = new Solution();
        String[] s = {"1100111011101001"};
        String[] ans = sol.solution(s);
    }

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i=0;i<s.length;i++){
            answer[i] = makeStr(s[i]);
        }
        return answer;
    }

    private String makeStr(String s){

        int l = 0, r = s.length()-1;
        int lstack = 0;
        int rstack = 0;

        StringBuilder sb = new StringBuilder(s);

        while(l<r+2){

            System.out.println("l : " + l + " r : " + r + " lstack : "
                    + lstack + " rstack : " + rstack);

            if(lstack<3){

                if(sb.charAt(l)=='1'){
                    if(lstack<2) l++;
                    lstack++;
                }else{
                    lstack = 0;
                    l++;
                }
            }if(rstack<3){

                if(sb.charAt(r)=='0'){
                    rstack = 1;
                    r--;
                }else{
                    if(rstack==2){
                        rstack++;
                    }else{
                        if(rstack>0) rstack++;
                        r--;
                    }
                }
            }else if(lstack==3&&rstack==3){
                //System.out.println("l : " + l + " r : " + (r+2));
                sb.setCharAt(l,'0');
                sb.setCharAt(r+2,'1');
                lstack = 0;
                rstack = 0;
                l=0;
                r=s.length()-1;
            }

        }
        System.out.println("ans : " + sb);
        return sb.toString();
    }
}