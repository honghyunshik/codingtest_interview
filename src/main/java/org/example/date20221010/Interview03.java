package org.example.date20221010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//파이썬 알고리즘 인터뷰 책 03번 문제 - 로그 파일 재정렬(148p)
//조건 1 : 로그의 가장 앞 부분은 식별자이다
//조건 2 : 문자로 구성된 로그가 숫자 로그보다 앞에 온다.
//조건 3 : 식별자는 순서에 영향을 끼치지 않지만, 문자가 동일한 경우 식별자 순으로 한다.
//조건 4 : 숫자 로그는 입력 순서대로 한다
public class Interview03 {

    public static void main(String[] args){

        String[] input = {"dig 8 1 5 1", "let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        printAnswer(getLog(input));
    }

    public static void printAnswer(ArrayList<Log> ans){

        String answer = "";

        for(Log log:ans){
            answer+=log.getTotal() + " , ";
        }
        System.out.println(answer);
    }

    public static ArrayList<Log> getLog(String[] input){

        ArrayList<Log> letters = new ArrayList<>();
        ArrayList<Log> numbers = new ArrayList<>();

        for(String str:input){
            String check = str.split(" ")[1];     //식별자 다음 문자가 숫자인지 글자인지 체크
            try{
                Double.parseDouble(check);
                String first = str.split(" ")[0];       //식별자를 객체의 first에다가 저장
                String[] after_lst = Arrays.copyOfRange(str.split(" "),1,str.split(" ").length);    //식별자를 제외한 나머지 배열
                String after = String.join(" ",after_lst);
                Log log = new Log(first,after,str);
                numbers.add(log);       //숫자는 numbers ArrayList에 add
            }catch(NumberFormatException e){
                String first = str.split(" ")[0];       //식별자를 객체의 first에다가 저장
                String[] after_lst = Arrays.copyOfRange(str.split(" "),1,str.split(" ").length);    //식별자를 제외한 나머지 배열
                String after = String.join(" ",after_lst);
                Log log = new Log(first,after,str);
                letters.add(log);       //문자는 letters ArrayList에 add
            }
        }
        letters.sort(Comparator.comparing(Log::getAfter).thenComparing(Log::getFirst));     //After 기준으로 1차 정렬, 그리고 First 기준으로 2차 정렬


        letters.addAll(numbers);        //문자로 구성된 로그가 숫자 로그보다 앞에 온다
        return letters;
    }
}


//Comparator을 통한 정렬을 하기 위해 클래스 생성
class Log{
    String first;
    String after;
    String total;

    public Log(String first, String after, String total){
        this.first = first;
        this.after = after;
        this.total = total;
    }

    public String getFirst(){
        return first;
    }
    public String getAfter(){
        return after;
    }
    public String getTotal(){
        return total;
    }

}
