package org.dump.aaa;

import java.util.ArrayList;

import static org.dump.Test11.getColor;

public class Test79 {
    int x,y;
    char zz;
    String k;
    Test79(int x, int y){
        //System.out.println(this.x  +" dd" + this.y);
        //System.out.println(k);
        initialize(x,y);
    }

    public void initialize(int x, int y){
        this.x = x*x;
        this.y = y*y;
    }
    private void hi(){

    }

    public static void main(String[] args){

        ArrayList<Integer> a = new ArrayList<>();
        a.add(null);
        a.add(null);
        a.add(null);
        a.remove(null);
        System.out.println(a.size());

    }
}

class A{


    public static void main(String[] args){


        Test79 t = new Test79(1,2);

    }
}