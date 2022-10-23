package org.example.data20221018;

import java.util.Stack;

//파이썬 알고리즘 인터뷰 책 16번 문제 - 두 수의 덧셈(221p)
//역순으로 저장된 연결 리스트의 숫자를 더하라
public class Interview16 {

    public static void main(String[] args){

        //LinkedList 2 -> 4 -> 3 생성
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        //LinkedList 5 -> 6 -> 4 생성
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node reverseL1 = reverseNode1(l1,null);
        Node reverseL2 = reverseNode2(l2);

        Node answer = getLinkedListFromTwoInteger(getIntegerFromLinkedList(reverseL1),getIntegerFromLinkedList(reverseL2));
        while(answer!=null){
            System.out.print(answer.data + " -> ");
            answer = answer.next;
        }
    }

    public static Node reverseNode1(Node head, Node nowHead){

        if(head!=null){
            Node next = head.next;
            head.next = nowHead;
            nowHead = head;

            return reverseNode1(next,nowHead);
        }

        return nowHead;
    }

    public static Node reverseNode2(Node head){

        Node prev = null;

        while(head!=null){
            Node now = head;
            head = head.next;
            now.next = prev;
            prev = now;
        }

        return prev;
    }

    public static int getIntegerFromLinkedList(Node node){

        Stack<Integer> stack = new Stack<>();
        while(node!=null){
            stack.push(node.data);
            node = node.next;
        }

        int num = 0;
        int line=1;
        while(stack.size()!=0){
            num+=stack.pop()*line;
            line*=10;
        }

        return num;
    }

    public static Node getLinkedListFromTwoInteger(int a, int b){

        int num = a+b;  //807  목표 : 7 -> 0 -> 8
        String num_str = Integer.toString(num);
        Node prev = null;
        for(int i=0;i<num_str.length();i++){
            Node now = new Node(num_str.charAt(i)-48);
            now.next = prev;
            prev = now;
        }

        return prev;
    }
}
