package org.example.date20221011;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//파이썬 알고리즘 인터뷰 책 09 번 문제 - 세 수의 합(184p)
//배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라
public class Interview09 {

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        for(int num:nums){
            System.out.print(num + " ");
        }
        System.out.println();

        printAnswer(getThreeWithMap(nums));
        printAnswer(getThreeWithPointer(nums));

    }

    //하나의 수를 뺀 나머지 수를 HashMap에 넣어놓고 나머지를 조합한다
    //시간은 브루트 포스가 O(n^3)일 떄 O(n^2)이다
    public static ArrayList<int[]> getThreeWithMap(int[] input){

        ArrayList<int[]> answer = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<input.length;i++){
            map.put(-input[i],i);
        }

        for(int i=0;i<input.length-1;i++){
            if(i>0&&input[i]==input[i-1]){
                continue;
            }
            for(int j=i+1;j<input.length;j++){
                int sum = input[i] + input[j];
                if(map.containsKey(sum)&&map.get(sum)>i&&map.get(sum)>j){
                    int[] tempAns = new int[3];
                    tempAns[0] = input[i];
                    tempAns[1] = input[j];
                    tempAns[2] = input[map.get(sum)];
                    answer.add(tempAns);
                }
            }
        }

        return answer;
    }

    //두 개의 포인터(left, right 활용)
    public static ArrayList<int[]> getThreeWithPointer(int[] input){
        ArrayList<int[]> answer = new ArrayList<>();

        for(int i=0;i<input.length-2;i++){
            int left = i+1;
            int right = input.length-1;

            //중복체크
            if(i>0&&input[i]==input[i-1]){
                continue;
            }

            while(left<right){
                int sum = input[i] + input[left] + input[right];
                if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    int[] tempAns = {input[i],input[left],input[right]};
                    answer.add(tempAns);
                    while(input[left]==input[left+1]&&left<right){
                        left++;
                    }
                    while(input[right]==input[right-1]&&left<right){
                        right--;
                    }
                    left++;right--;
                }

            }
        }

        return answer;
    }

    public static void printAnswer(ArrayList<int[]> ans){
        for(int[] arr:ans){

            for(int num:arr){
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }


}