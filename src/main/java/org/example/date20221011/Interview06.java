package org.example.date20221011;

//파이썬 알고리즘 인터뷰 책 06번 문제 - 가장 긴 팰린드롬 부분 문자열(159p)
//가장 긴 팰린드롬 부분 문자열을 출력하라
public class Interview06 {
    public static void main(String[] args){

        String input1 = "abcdedcbaaaaaaaaaaaa";
        String input2 = "cbbdddd";

        System.out.println("input 1 : " + getLongPal(input1));
        System.out.println("input 2 : " + getLongPal(input2));
    }

    public static String getLongPal(String input) {

        String answer = "";       //가장 긴 팰린드롬 문자열을 answer에 저장
        int max = 0;        //가장 긴 문자열의 길이를 max에 저장
        //길이가 1인 경우 문자열 그대로 반환
        if (input.length() < 2) {
            return input;
        } else {
            for (int i = 0; i < input.length() - 1; i++) {

                //홀수일 경우의 팰린드롬
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
                    int nowMax = right - left + 1;      //현재 계산한 팰린드롬의 길이
                    //현재의 팰린드롬의 길이가 지금까지 나온 최대 팰린드롬 길이보다 길 떄
                    if (nowMax > max) {
                        answer = input.substring(left, right+1);
                        max = nowMax;
                    }
                    left--;
                    right++;
                }

                //짝수일 경우의 팰린드롬
                left = i - 1;
                right = i + 2;
                if(input.charAt(i)==input.charAt(i+1)){
                    int nowMax = 2;
                    if(nowMax>max){

                        answer = input.substring(i,nowMax+1);
                        max = nowMax;
                    }
                    while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
                        nowMax = right - left + 1;      //현재 계산한 팰린드롬의 길이
                        //현재의 팰린드롬의 길이가 지금까지 나온 최대 팰린드롬 길이보다 길 떄
                        if (nowMax > max) {
                            answer = input.substring(left, right+1);
                            max = nowMax;
                        }
                        left--;
                        right++;
                    }
                }

            }
            //팰린드롬 없으면 없다고 반환
            if(answer.equals("")){
                return "팰린드롬이 존재하지 않습니다";
            }
            return answer;
        }
    }

}
