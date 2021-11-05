package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 영화감독 숌
public class Ex1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int count = 1;
        int i = 666;

        while (count != n){
            i++;
            if(Integer.toString(i).contains("666")) count++;
        }

        System.out.println(i);
    }
}
