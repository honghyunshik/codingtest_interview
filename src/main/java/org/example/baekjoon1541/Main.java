package org.example.baekjoon1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String tempNum = "";
        int ans = 0;
        int num = 0;
        boolean isMinus = false;
        for(int i=0;i<input.length();i++){

            char now = input.charAt(i);
            if(now=='+'||now=='-'){
                num = Integer.parseInt(tempNum);
                if(isMinus) ans -= num;
                else ans += num;
                if(now=='-') isMinus = true;
                tempNum = "";
            }else{
                tempNum += now;
            }
        }
        num = Integer.parseInt(tempNum);
        if(isMinus) ans -= num;
        else ans += num;
        System.out.println(ans);

    }

}
