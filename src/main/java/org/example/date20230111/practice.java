package org.example.date20230111;

import java.util.Arrays;

public class practice {

    public static void main(String[] args){

        CStore[] array = makeXY();
        Arrays.sort(array);
        Node58 node = makeLinkedList(array);
        for(int i=0;i<15;i++){
            System.out.println((char)node.val);
            node = node.next;
        }

    }

    public static CStore[] makeXY(){

        CStore[] list = new CStore[10];
        int idx = 0;
        for(char str='A';str<='J';str++){
            list[idx++] = new CStore(str);
        }
        return list;
    }

    public static Node58 makeLinkedList(CStore[] list){

        Node58 head = new Node58(list[0].name),p = head;
        for(int i=1;i<list.length;i++){
            p.next = new Node58(list[i].name);
            p = p.next;
            if(i==list.length-1){
                p.next = head;
            }
        }


        return head;
    }
}

class CStore implements Comparable<CStore>{
    int x,y;
    double dis;
    char name;
    CStore(char name){
        this.name = name;
        this.x = (int)(Math.random()*100+1);
        this.y = (int)(Math.random()*100+1);
        this.dis = Math.sqrt((double)x*x+y*y);
    }

    @Override
    public int compareTo(CStore o) {
        if(this.dis<o.dis){
            return -1;
        }else return 1;
    }
}
