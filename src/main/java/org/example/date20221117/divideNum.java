package org.example.date20221117;

    import java.util.ArrayList;
    import java.util.Arrays;

public class divideNum {

    public static void main(String[] args){
        System.out.println(Math.max(solution(new int[]{10, 17},new int[]{5, 20}),solution(new int[]{5, 20},new int[]{10, 17})));
        System.out.println(Math.max(solution(new int[]{10, 20},new int[]{5, 17}),solution(new int[]{5, 17},new int[]{10, 20})));
        System.out.println(Math.max(solution(new int[]{14, 35,119},new int[]{18,30,102}),solution(new int[]{18,30,102},new int[]{14,35,119})));


    }

    public static int solution(int[] arrayA, int[] arrayB){

        int answer = 0;

        Arrays.sort(arrayA);
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=2;i<=arrayA[0];i++){
            if(arrayA[0]%i==0) list.add(i);
        }

        for(int i:list){

            boolean first = true;
            boolean second = true;

            for(int j:arrayA){
                if(j%i!=0) first = false;
            }
            for(int j:arrayB){
                if(j%i==0) first = false;
            }
            if((first&&second)&&answer<i) answer = i;
        }
        return answer;
    }

    public static boolean isNotDivide(int[] arr, int num){

        for(int i:arr){
            if(i%num==0) return false;
        }

        return true;
    }
}
