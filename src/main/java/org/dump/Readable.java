package org.dump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Readable {
    public void a();
    default void b(){

    };
}

class Book implements Readable{

    Book(int a){

    }
    public void a(){

    }
    public void b(){

    }
}

class EBook extends Book{
    static double area;
    int b= 2, h=3;

    EBook(int a) {
        super(a);
    }

    public static void main(String[] args){

        String[] arr = {
                new String("1"),
                new String("2"),
                new String("3"),
                new String("4"),
                new String("5")
        };
        arr[2] = arr[4];
        //Arrays.stream(arr).forEach(System.out::println);

        short s1 = 200;
        Integer s2 = 400;
        Long s3 = (long) (s1+s2);
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(list.remove(1));
    }


}
