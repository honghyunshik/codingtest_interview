package org.example.date20221011;

import java.util.HashMap;

//파이썬 알고리즘 인터뷰 책 07번 문제 - 두 수의 합(173p)
//덧셈하여 타겟을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라
public class Interview07 {
    public static void main(String[] args){

        int[] nums = {2,7,11,15};
        int target = 9;
        printAnswer(getSumWithBrute(nums,target));
        printAnswer(getSumWithMap(nums,target));

    }

    //브루트 포스로 풀기
    //시간복잡도가 n^2이다
    public static int[] getSumWithBrute(int[] nums,int target){
        
        int[] answer = new int[2];
        //2중 for문 돌리면서 정답 찾기
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }

    //HashMap으로 풀기
    //시간복잡도가 n이다
    public static int[] getSumWithMap(int[] input,int target){

        int[] answer = new int[2];
        //HashMap<target-value,index>
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<input.length;i++){
            map.put(target-input[i],i);
        }

        for(int i=0;i<input.length;i++){

            if(map.containsKey(input[i])){
                answer[0] = i;
                answer[1] = map.get(input[i]);
                break;
            }
        }
        return answer;
    }

    public static void printAnswer(int[] ans){
        for(int num:ans){
            System.out.print(num + " ");
        }
    }

}
