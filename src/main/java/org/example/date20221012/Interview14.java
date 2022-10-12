package org.example.date20221012;

import java.util.Deque;
import java.util.LinkedList;

//파이썬 알고리즘 인터뷰 책 14번 문제 - 두 정렬 리스트의 병합(213p)
//정렬되어 있는 두 연결 리스트를 합쳐라
public class Interview14 {

    public static void main(String[] args){

        //deque 1->2->4 와 1->3->4 생성
        int[] input1 = {1,2,4};
        int[] input2 = {1,3,4};
        Deque<Integer> deq1 = new LinkedList<>();
        Deque<Integer> deq2 = new LinkedList<>();
        for(int num:input1){
            deq1.add(num);
        }
        for (int num:input2){
            deq2.add(num);
        }
        System.out.println(getSumDeque(deq1,deq2));
    }

    public static Deque<Integer> getSumDeque(Deque<Integer> input1, Deque<Integer> input2){
        Deque<Integer> answer = new LinkedList<>();

        while(input1.size()>0||input2.size()>0) {
            if (input1.size() == 0) {
                answer.add(input2.pop());
            } else if (input2.size() == 0) {
                answer.add(input1.pop());
            } else {
                if (input1.getFirst() > input2.getFirst()) {
                    answer.add(input2.pop());
                } else {
                    answer.add(input1.pop());
                }
            }
        }

        return answer;
    }
}
