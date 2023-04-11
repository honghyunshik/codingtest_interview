package org.example.조이스틱;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        String input = "BBBBAAAAAB";
        System.out.println(sol.solution(input));
    }
    public int solution(String name) {

        int answer = Integer.MAX_VALUE  ;
        boolean[] visited = new boolean[name.length()];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int idx = now[0];

            int l = idx>0?idx-1:name.length()-1;
            int r = idx<name.length()-1?idx+1:0;
            int ans = now[1] + getNum('A',name.charAt(idx));
            visited[idx] = true;
            while(r<name.length()&&name.charAt(r)=='A'){
                r++;
                if(r==name.length()) r=0;
            }
            while(l>=0&&name.charAt(l)=='A'){
                l--;
                if(l<0) l = name.length()-1;
            }
            System.out.println(idx + " " + l + "," + r);
            if(visited[l]&&visited[r]){
                answer = Math.min(answer,ans);
                continue;
            }
            int leftDis = getDis(l,idx,name.length());
            int rightDis = getDis(r,idx,name.length());

            if(!visited[l]){
                queue.add(new int[]{l,ans+leftDis});
            }
            if(!visited[r]){
                queue.add(new int[]{r,ans+rightDis});
            }

        }


        return answer;
    }

    int getDis(int l, int r, int len){

        int max = Math.max(l,r);
        int min = Math.min(l,r);
        if(max-min<=len/2) return max-min;
        return len-max+min;
    }
    int getNum(int a, int b){

        int max = Math.max(a,b);
        int min = Math.min(a,b);

        if(max-min<=13) return max-min;
        return (int)'Z'-max + min - (int)'A' + 1;
    }
}