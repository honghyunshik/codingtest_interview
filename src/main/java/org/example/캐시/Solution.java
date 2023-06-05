package org.example.캐시;

public class Solution {

    public static void main(String[] args){

        Node head = new Node("1");
        head.right = new Node("2");
        head.right.right = new Node("3");
        Node node = head;
        while(node.right!=null&&!node.right.city.equals("2")){
            node = node.right;
        }
        Node next = node.right;
        node.right = node.right.right;
        next.right = head;
        head = next;


    }
}

class Node{
    String city;
    Node left,right;
    Node(String city){
        this.city = city;
    }

}