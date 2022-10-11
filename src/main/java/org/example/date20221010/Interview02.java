package org.example.date20221010;


//파이썬 알고리즘 인터뷰 책 02번 문제 - 문자열 뒤집기(145p)
public class Interview02 {

    public static void main(String[] args){

        String[] input1 = {"h","e","l","l","o"};
        String[] input2 = {"H","a","n","n","a","h"};

        printAnswer(getReverse(input1));
    }

    //투 포인터를 활용한 방식
    public static String[] getReverse(String[] input){

        int left=0, right= input.length-1;
        String temp="";

        while(left<right){
            temp = input[left].toLowerCase();
            input[left] = input[right].toLowerCase();
            input[right] = temp;
            left++;
            right--;
        }

        return input;


    }

    public static void printAnswer(String[] ans){
        String answer = String.join(" ", ans);
        System.out.println(answer);
    }
}
