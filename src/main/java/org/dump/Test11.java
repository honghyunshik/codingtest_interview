package org.dump;

import java.io.IOException;

public class Test11 extends X{

    public static void main(String[] args){

        System.out.println(new StringBuilder("hello"));
        System.out.println(new Boolean(true));
    }

    public static String getColor(){
        return "green";
    }

    Test11(){
        super();
    }

}

class X{
    public void printFileContent() throws Exception{
        throw new IOException();
    }
}

abstract class Y{
    int a;
}
