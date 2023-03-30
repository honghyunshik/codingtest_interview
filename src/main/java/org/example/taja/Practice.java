package org.example.taja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

    public static void main (String[] args)throws Exception{

        StringBuilder sb = new StringBuilder(5);
        Practice p = new Practice();
        p.readCard(10);
    }

    void readCard(int cardNo) throws Exception{
        System.out.println("hi");
    }

    void checkCard(int cardNo) throws RuntimeException{
        System.out.println("hi2");
    }
}

class Hi{
    Hi(int a){
        this.a = a;
    }

    int a = 10;
}
