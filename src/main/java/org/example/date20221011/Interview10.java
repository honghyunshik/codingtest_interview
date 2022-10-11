package org.example.date20221011;

import java.util.Arrays;

//파이썬 알고리즘 인터뷰 책 10번 문제 - 배열 파티션(190p)
//n개의 페어를 이용한 min(a,b)의 합으로 만들 수 있는 가장 큰 수를 출력하라
public class Interview10 {
    public static void main(String[] args){

        int[] input = {1,4,3,2,5,6};
        Arrays.sort(input);

        int answer = 0;

        for(int i=0;i<input.length;i+=2){
            answer += input[i];
        }
        System.out.print(answer);
    }

}
