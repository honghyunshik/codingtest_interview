package org.example.programmers2;//알파벳은 26개
import java.util.*;
class Solution {
    public int solution(String name) {

        int answer = Integer.MAX_VALUE;
        boolean[] visited_left = new boolean[name.length()];
        boolean[] visited_right = new boolean[name.length()];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,getAlphabetChange(name.charAt(0)),0));
        visited_left[0] = true;
        visited_right[0] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int left = now.index-1;
            int right = now.index+1;
            if(left==-1){
                left = name.length()-1;
            }
            if(visited_left[left]&&visited_right[right]){
                answer = Math.min(answer,now.total);
            }
            if(!visited_left[left]){
                visited_left[left] = true;
                if(name.charAt(left)=='A'){
                    queue.add(new Node(left,now.total + getAlphabetChange(name.charAt(left)), now.stack+1));
                }else{
                    queue.add(new Node(left,now.total + getAlphabetChange(name.charAt(left))+ now.stack + 1, 0));
                }

            }
            if(right<name.length()&&!visited_left[right]){
                visited_right[right] = true;
                if(name.charAt(right)=='A'){
                    queue.add(new Node(right,now.total + getAlphabetChange(name.charAt(right)),now.stack+1));
                }else{
                    queue.add(new Node(right,now.total + getAlphabetChange(name.charAt(right))+now.stack+1, 0));
                }

            }

        }


        return answer;
    }

    public int getAlphabetChange(char l){

        return Math.min(Math.abs(l-'A'),Math.abs('Z'-l + 1));
    }

}
class Node{
    int index,total,stack;
    Node(int index, int total, int stack){
        this.index = index;
        this.total = total;
        this.stack = stack;
    }
}