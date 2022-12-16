package org.example.date20221124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview27 {

    //k개의 정렬된 리스트를 1개의 정렬된 리스트로 병합하라
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Node node1 = new Node(1);
        node1.next = new Node(4);
        node1.next.next = new Node(5);

        Node node2 = new Node(1);
        node2.next = new Node(3);
        node2.next.next = new Node(4);

        Node node3 = new Node(2);
        node3.next = new Node(6);

        Node[] nodeList = new Node[]{node1,node2,node3};
        Node answer = solution(nodeList);

        while(answer!=null){
            System.out.print(answer.val + " ");
            answer = answer.next;
        }
    }

    public static Node solution(Node[] nodeList){

        Node result = new Node();
        Node temp = result;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                return Integer.compare(o1.val,o2.val);
            }
        });

        for(Node node:nodeList){
            while(node!=null){
                pq.add(node);
                node = node.next;
            }
        }

        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;

        }

        return result.next;




    }

}
