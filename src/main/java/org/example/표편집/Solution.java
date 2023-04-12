package org.example.표편집;

import java.util.*;

class Solution {


    public static void main(String[] args){
        Solution sol = new Solution();
        String[] input = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println(sol.solution(8,2,input));
    }
    public String solution(int n, int k, String[] cmd) {

        boolean[] deleted = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0;i<n;i++){
            list.add(i);
        }

        for(int i=0;i<cmd.length;i++){

            String now = cmd[i];

            System.out.println("k : " + k + " cmd : " + now + " size : " + list.size());
            if(now.equals("C")){

                int delete = list.get(k);
                deleted[delete] = true;
                stack.add(delete);
                list.remove(k);
                if(k==list.size()-1) k--;

            }else if(now.equals("Z")){

                int last = stack.pop();
                deleted[last] = false;
                int idx = list.size()-1;
                for(int j=0;j<list.size()-1;j++){
                    if(list.get(j+1)>last){
                        idx = j;
                        break;
                    }
                }
                list.add(idx,last);

            }else{
                String command = now.split(" ")[0];
                int dis = Integer.parseInt(now.split(" ")[1]);
                if(command.equals("D")) k += dis;
                else k-=dis;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(deleted[i]) sb.append("X");
            else sb.append("O");
        }
        return sb.toString();
    }
}