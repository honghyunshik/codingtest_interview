package org.example.date20221019;

public class asdfas {
    public static void main(String[] args){
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(4);
        a.next.next.next.next = new Node(5);

        Node b = new Node();
        b.data = a.data;
        b.next=a.next;

        a.next = a.next.next;  //1 -> 3 -> 4 -> 5


        while(a!=null){
            System.out.print(a.data + " -> ");
            a=a.next;
        }
        while(b!=null){
            System.out.print(b.data + " -> ");
            b=b.next;
        }

        System.out.println(" a : " + System.identityHashCode(a));
        System.out.println(" b : " + System.identityHashCode(b));

    }
}
