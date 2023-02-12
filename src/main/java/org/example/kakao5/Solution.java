package org.example.kakao5;

class Solution {

    static int user_count = 0;
    static int user_sale = 0;

    public int[] solution(int[][] users, int[] emoticons) {

        int[] answer = new int[2];
        int[] user_buy = new int[users.length];
        emoticon(emoticons, 0, users, user_buy);
        answer[0] = user_count;
        answer[1] = user_sale;
        return answer;
    }

    public void emoticon(int[] emoticons, int index, int[][] users, int[] user_buy){

        if(index==emoticons.length){
            int temp_user_count = 0;
            int temp_user_sale = 0;

            for(int i=0;i<user_buy.length;i++){
                if(user_buy[i]>=users[i][1]){
                    temp_user_count++;
                }else{
                    temp_user_sale += user_buy[i];
                }
            }
            if(temp_user_count>user_count){
                user_count = temp_user_count;
                user_sale = temp_user_sale;
            }else if(temp_user_count==user_count){
                user_sale = Math.max(temp_user_sale,user_sale);
            }
            return;
        }

        for(int per=10;per<=40;per+=10){
            for(int i=0;i<users.length;i++){
                int[] user = users[i];
                //user[0] => 퍼센트, user[1] => 최소금액
                //이모티콘 할인율을 넘었으므로 구매

                //if(i==0) System.out.println(user[0] + " " + i);
                if(user[0]<=per){
                    user_buy[i] += emoticons[index] * (100-per) / 100;
                }
            }

            emoticon(emoticons, index+1, users, user_buy);

            for(int i=0;i<users.length;i++){
                int[] user = users[i];
                //user[0] => 퍼센트, user[1] => 최소금액
                //이모티콘 할인율을 넘었으므로 구매
                if(user[0]<=per){
                    user_buy[i] -= emoticons[index] * (100-per) / 100;
                }
            }


        }


    }
}