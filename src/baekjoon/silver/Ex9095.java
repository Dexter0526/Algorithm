package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 1, 2, 3 더하기
public class Ex9095 {
    private static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        count = new int[T];

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(bufferedReader.readLine());
            plus(0, n, i);
        }

        for(int i = 0; i < T; i++){
            System.out.println(count[i]);
        }
    }

    private static void plus(int number, int n, int i){
        if(number == n){
            count[i]++;
            return;
        }

        if(number > n) return;

        plus(number+1, n, i);
        plus(number+2, n, i);
        plus(number+3, n, i);
    }
}
