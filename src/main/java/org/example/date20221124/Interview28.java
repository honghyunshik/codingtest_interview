package org.example.date20221124;

import java.util.Arrays;
import java.util.HashMap;

public class Interview28 {

    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();

        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.put(102,100);
        hashMap.remove(102);
        System.out.println(hashMap.get(102));
        System.out.println(hashMap.get(2));
    }


}

class MyHashMap{

    private Bucket[] buckets;
    private final int BUCKET_CAPACITY = 100;

    private class Bucket{

        Node node;
        public Bucket(Node node){
            this.node = node;
        }

    }

    private class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next){

            this.key = key;
            this.value = value;
            this.next = next;

        }

    }



    public MyHashMap(){
        buckets = new Bucket[10000];
    }

    public void put(int key, int value){

        int index = key/BUCKET_CAPACITY;

        if(buckets[index]==null||buckets[index].node==null){
            buckets[index] = new Bucket(new Node(key,value,null));
        }else{
            Node node = buckets[index].node;

            while(node!=null){
                if(node.key==key){
                    node.value = value;
                    return;
                }
                if(node.next==null){
                    node.next = new Node(key,value,null);
                    return;
                }

                node = node.next;
            }
        }


    }

    public int get(int key){

        int index = key/BUCKET_CAPACITY;

        if(buckets[index]!=null){
            Node node = buckets[index].node;

            while(node!=null){
                if(node.key==key){
                    return node.value;
                }
                node = node.next;
            }
            return -1;
        }
        return -1;
    }

    public void remove(int key){

        int index = key/BUCKET_CAPACITY;

        if(buckets[index]!=null){
            Node node = buckets[index].node;
            Node prev = null;
            while(node!=null){
                if(node.key==key){
                    if(prev==null){
                        buckets[index].node = node.next;
                    }else{
                        prev.next = node.next;
                    }
                    return;

                }
                prev = node;
                node = node.next;

            }
        }
    }


}
