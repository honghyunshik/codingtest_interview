package org.example.date20221024;

import java.util.ArrayList;

public class Interview27 {

    public static void main(String[] args){

        MinHeap minHeap = new MinHeap();
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(8);
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(5);
        minHeap.delete();
        ArrayList<Integer> min_heap = minHeap.heap;
        for(Integer i:min_heap){
            System.out.print(i + " -> ");
        }

    }
}

//최소힙
class MinHeap{

    ArrayList<Integer> heap;

    MinHeap(){
        heap = new ArrayList<>();
        heap.add(0);    //0번째 인덱스는 사용 X
    }

    public boolean insert(int val){

        heap.add(val);
        int index = heap.size()-1;      //heap에 저장된 index 정보

        while(index>1 && heap.get(index/2)>heap.get(index)){

            int tmp = heap.get(index/2);
            heap.set(index/2,val);
            heap.set(index,tmp);

            index/=2;
        }
        return true;
    }

    public int delete(){

        if(heap.size()==1){
            return -1;
        }
        int delitem = heap.get(1);      //삭제한 root값 반환

        heap.set(1,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int pos = 1;        //왼쪽 자식의 index 값
        while(pos*2<heap.size()){

            int minIndex = pos*2;       //왼쪽 자식의 index값
            int min = heap.get(minIndex);      //왼쪽 자식의 값

            //왼쪽자식이랑 오른쪽 자식의 값 비교
            if(minIndex+1<heap.size()&&heap.get(minIndex+1)<min){
                minIndex++;
                min = heap.get(minIndex);
            }

            if(min>heap.get(pos)) break;

            int tmp = heap.get(pos);
            heap.set(pos,min);
            heap.set(minIndex,tmp);
            pos = minIndex;

        }

        return delitem;
    }
}

class MaxHeap{

    ArrayList<Integer> heap;
    MaxHeap(){
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int val){

        heap.add(val);
        int index = heap.size()-1;
        while(index>1&&heap.get(index/2)<heap.get(index)){

            int tmp = heap.get(index/2);
            heap.set(index/2,val);
            heap.set(index,tmp);
            index/=2;
        }
    }

    public int delete(){

        int delitem = heap.get(1);

        //heap이 비어있으면 -1 반환
        if(heap.size()==1){
            return -1;
        }





        return delitem;
    }


}