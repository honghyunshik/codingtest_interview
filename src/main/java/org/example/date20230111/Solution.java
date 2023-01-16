package org.example.date20230111;

import java.util.Arrays;

class Solution {
    static Node node;
    static int num;
    static int ans;


    public static void main(String[] args){

        long[] numbers = new long[500];
        for(int i=0;i<500;i++){
            numbers[i] = i+1;
        }
        Solution sol = new Solution();
        int[] answer = sol.solution(numbers);
        System.out.println(Arrays.toString(answer));
    }
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i=0;i<numbers.length;i++){
            node = new Node(1);
            num = 0;
            ans = 1;
            getBinaryNum(numbers[i]);
            preOrder(node);
            answer[i] = ans;
        }
        return answer;
    }
    public String getBinaryNum(long num){

        String binaryNumber = Integer.toBinaryString((int) num);
        long now = 0;
        int idx = 0;
        int i=1;
        while(num>now){
            idx = (int)Math.pow(2,i)-1;
            now = (long)Math.pow(2,idx)-1;
            i++;
        }
        i--;
        String str = "";
        makeBinaryNode(node,1,i);
        for(int j=binaryNumber.length();j<idx;j++){
            str += "0";
        }


        str+=binaryNumber;
        postOrderSearch(node,str);
        return str;
    }

    public void makeBinaryNode(Node node, int depth, int target){

        if(depth==target){
            return;
        }
        node.left = new Node(1);
        node.right = new Node(1);
        makeBinaryNode(node.left,depth+1,target);
        makeBinaryNode(node.right,depth+1,target);
    }

    public void postOrderSearch(Node node, String binaryNum){

        if(node==null) return;
        if(node.left!=null){
            postOrderSearch(node.left,binaryNum);
        }
        if(binaryNum.charAt(num++)=='0'){
            node.val = 0;
        }
        if(node.right!=null){
            postOrderSearch(node.right,binaryNum);
        }

    }

    public void preOrder(Node node){

        if(node==null) return;
        if(node.left!=null&&node.val==0&&node.left.val==1){
            ans = 0;
            return;
        }
        if(node.right!=null&&node.val==0&&node.right.val==1){
            ans = 0;
            return;
        }
        preOrder(node.left);
        preOrder(node.right);

    }
}