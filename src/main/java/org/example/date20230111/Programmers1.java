package org.example.date20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
    int val;
    Node left,right;
    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
//표현 가능한 이진트리 - 2023 KAKAO BLIND RECRUITMENT
public class Programmers1 {

    static Node node;
    static int num = 0;
    static boolean ans = true;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        node = new Node(1);
        getBinaryNum(num);
        preOrder(node);
        System.out.println(ans);


    }


    public static String getBinaryNum(int num){

        String binaryNumber = Integer.toBinaryString(num);
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

    public static void makeBinaryNode(Node node, int depth, int target){

        if(depth==target){
            return;
        }
        node.left = new Node(1);
        node.right = new Node(1);
        makeBinaryNode(node.left,depth+1,target);
        makeBinaryNode(node.right,depth+1,target);
    }

    public static void postOrderSearch(Node node, String binaryNum){

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

    public static void preOrder(Node node){

        if(node==null) return;
        preOrder(node.left);
        preOrder(node.right);
        if((node.left!=null&&node.val==0)&&(node.left.val==1&&node.right.val==1)){
            ans = false;
            return;
        }
    }
}

