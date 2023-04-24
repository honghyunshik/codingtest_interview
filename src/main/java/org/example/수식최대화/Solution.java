package org.example.수식최대화;

class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String expression = "50*6-3*2";
        System.out.println(sol.solution(expression));
    }
    public long solution(String expression) {

        long answer = 0;

        String ans = makeStr(makeStr(makeStr(expression,'+'),'-'),'*');
        System.out.println(ans);


        return answer;
    }

    String makeStr(String s, char k){

        StringBuilder sb = new StringBuilder();
        System.out.println(s);
        int backStart = 0;
        for(int i=0;i<s.length();i++){

            char now = s.charAt(i);

            if(now=='-'||now=='+'||now=='*'){
                if(now==k){
                    int id = sb.length()-2;
                    while(sb.length()>0&&id>=0&&sb.charAt(id)!='-'&&sb.charAt(id)!='+'&&sb.charAt(id)!='*'){
                        id--;
                    }
                    int left = 0;
                    if(id==-2){
                        left = Integer.parseInt(s.substring(0,i));
                    }else{
                        //System.out.println(sb.toString() + " " +  (id+1) + " " + (sb.length()-1));
                        left = Integer.parseInt(sb.substring(id+1,sb.length()-1));
                    }

                    int idx = i;
                    while(idx<s.length()&&s.charAt(idx)!='-'&&s.charAt(idx)!='+'
                            &&s.charAt(idx)!='*'){
                        idx++;
                    }
                    int right = 0;
                    System.out.println(s + " i : " + (i+1) + " idx : " + idx + " left : " + left);
                    right = Integer.parseInt(s.substring(i+1,idx));
                    int sum = left*right;
                    sb.append(sum);
                    i = idx;

                }else{
                    sb.append(s.substring(backStart,i+1));
                }
                backStart = i+1;
            }

        }
        sb.append(s.substring(backStart,s.length()));
        return sb.toString();
    }



}