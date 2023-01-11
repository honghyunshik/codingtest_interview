package org.example.date20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node58{
    Node58 next;
    int val;
    Node58(int val){
        this.val = val;
        this.next = null;
    }
}
public class Interview58 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Node58 node = null;
        for(int i=0;i<4;i++){
            int num = Integer.parseInt(st.nextToken());
            node = insertNode(node,num);
        }

    }

    public static Node58 insertNode(Node58 node, int val){

        if(node==null) return new Node58(val);
        node.next = insertNode(node.next, val);
        return node;
    }

    public static void merge_sort(Node58 node){
        merge_sort(node,0,N-1);
    }

    public static void merge_sort(Node58 node, int l, int r){

        if(l==r) return;
        int mid = (l+r)/2;
        merge_sort(node,l,mid);
        for(int i=0;i<mid;i++){
            node = node.next;
        }
        merge_sort(node,mid+1,r);
        merge(node,l,mid,r);
    }
    public static void merge(Node58 node, int l, int mid, int r){

    }


}
