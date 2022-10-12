package org.example.date20221012;

//파이썬 알고리즘 인터뷰 책 12번 문제 - 주식을 사고팔기 가장 좋은 시점(195p)
//한 번의 거래로 낼 수 있는 최대 이익을 산출하라
public class Interview12 {

    public static void main(String[] args){
        int[] input = {7,1,5,3,6,4,8};
        System.out.println(getMaxProfit(input));

    }

    public static int getMaxProfit(int[] input){

        int left = 0;
        int right = input.length-1;
        int minLeft = input[left];
        int maxRight = input[right];

        while(left<right){
            maxRight = Math.max(maxRight, input[right]);
            minLeft = Math.min(minLeft, input[left]);
            left++;
            right--;
        }

        return maxRight-minLeft;


    }

}
