package org.example.insa;

import java.util.*;

class Solution {

    public static void main(String[] args){
        int[][] scores = {{6,1},{4,4},{5,5}};
        Solution sol = new Solution();
        System.out.println(sol.solution(scores));
    }

    public int solution(int[][] scores) {
        int answer = 1;
        int wanho_l = scores[0][0];
        int wanho_r = scores[0][1];
        int sum = wanho_l + wanho_r;
        PriorityQueue<Person> pq = new PriorityQueue<>();
        for(int[] i:scores) {
            pq.add(new Person(i[0], i[1]));
        }
        int left = -1, right = -1;
        while(left!=wanho_l||right!=wanho_r){
            Person now = pq.poll();
            left = now.left;
            right = now.right;
            System.out.println(left + " " + right);
            if(left+right>sum) answer++;
        }
        return answer;
    }
}

class Person implements Comparable<Person>{
    int left, right;
    Person(int left, int right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int compareTo(Person o){
        if(o.left==this.left){
            return this.right-o.right;
        }
        return o.left - this.left;
    }
}

