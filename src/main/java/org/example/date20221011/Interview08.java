package org.example.date20221011;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

//파이썬 알고리즘 인터뷰 책 08 번 문제 - 빗물 트래핑(180p)
//높이를 입력받아 비 온후 얼마나 많은 물이 쌓일 수 있는지 계산하라
public class Interview08 {
    public static void main(String[] args){

        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};

        //System.out.println(getRainWithPointer(input));
        System.out.println(getRainWithStack(input));
    }


    public static int getRainWithStack(int[] input){

        int answer =0;

        Stack<Integer> stack = new Stack<>();       //변곡점 만나기 전까지의 index를 stack에 저장
        int top=0;
        for(int i=0;i<input.length;i++){

            //변곡점을 만나는 경우
            while(stack.size()!=0&&input[i]>input[stack.get(stack.size()-1)]){
                top = stack.pop();

                //stack에 쌓인 값이 없다 = 왼쪽에 벽이 없다
                if(stack.size()==0){
                    break;
                }

                int distance = i-stack.get(stack.size()-1)-1;
                int waters = Math.min(input[i],input[stack.get(stack.size()-1)])-input[top];

                answer += distance * waters;
            }
            stack.add(i);

        }


        return answer;
    }

    public static int getRainWithPointer(int[] input){

        int answer = 0;
        int left = 0, right = input.length-1;
        int left_max = input[left], right_max = input[right];

        while(left<right){

            left_max = Math.max(left_max,input[left]);      //왼쪽에서 가장 높은 높이
            right_max = Math.max(right_max,input[right]);       //오른쪽에서 가장 높은 높이

            //왼쪽 max가 더 높으면 오른쪽 포인터를 움직이고, 오른쪽 max가 더 높으면 왼쪽 포인터를 움직인다.
            if(left_max<=right_max){
                answer += left_max-input[left];
                left++;
            }else{
                answer += right_max-input[right];
                right--;
            }
        }

        return answer;
    }

}
