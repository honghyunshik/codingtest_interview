package org.example.date20221012;

//파이썬 알고리즘 인터뷰 책 11번 문제 - 자신을 제외한 배열의 곱(193p)
//배열을 입력받아 output[i]가 자신을 제외한 나머지 모든 요소의 곱셈 결과가 되도록 출력하라(나눗셈 금지)
public class Interview11 {
    public static void main(String[] args){
        int[] input = {1,2,3,4};
        //printAnswer(getMultipleWithAll(input));
        printAnswer(getMultiple(input));
    }

    //제일 먼저 떠오른 모든 곱을 구해놓고 나누는 방법 - 나눗셈 금지라는 것을 뒤늦게 확인했다
    public static int[] getMultipleWithAll(int[] input){
        int total = 1;
        for(int num:input){
            total*=num;
        }
        for(int i=0;i<input.length;i++){
            input[i] = total/input[i];
        }
        return input;
    }

    public static int[] getMultiple(int[] input){

        int[] answer = new int[input.length];
        int[] left = new int[input.length];
        int[] right = new int[input.length];

        //왼쪽 곱셈 array
        int start = 1;
        for(int i=0;i<input.length;i++){
            if(i>0){
                start *= input[i-1];
            }
            System.out.println("start : " + start);
             left[i] = start;
        }
        //오른쪽 곱셈 array
        start = 1;
        for(int i=input.length-1;i>=0;i--){
            if(i<input.length-1){
                start *= input[i+1];
            }
            System.out.println("start : " + start);
             right[i] = start;
        }
        for(int i=0;i<answer.length;i++){
            answer[i] = left[i] * right[i];
        }

    return answer;
    }

    public static void printAnswer(int[] ans){
        for(int num:ans){
            System.out.print(num + " ");
        }
    }
}
