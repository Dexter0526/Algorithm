package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 팰린드롬수
public class Ex1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String temp = bufferedReader.readLine();
            boolean result = true;
            if(temp.equals("0")) break;

            for(int i = 0; i < temp.length() / 2; i++){
                if(temp.charAt(i) != temp.charAt(temp.length() - 1 - i)){
                    result = false;
                    break;
                }
            }

            System.out.println(result == true ? "yes" : "no");
        }
    }
}
