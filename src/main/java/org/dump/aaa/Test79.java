package org.dump.aaa;

import static org.dump.Test11.getColor;

public class Test79 {
    int x,y;
    Test79(int x, int y){
        initialize(x,y);
    }

    public void initialize(int x, int y){
        this.x = x*x;
        this.y = y*y;
    }

    public static void main(String[] args){
        int x=3,y=5;
        Test79 t = new Test79(x,y);
        System.out.println(t.x + " " + t.y);
    }
}
