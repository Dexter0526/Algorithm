package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
// 피보나치 함수
public class Ex1003 {

    public static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(bufferedReader.readLine());
            fibonacci(n);
            stringBuilder.append(dp[n][0] + " " + dp[n][1]).append("\n");
        }

        System.out.println(stringBuilder);
    }

    public static Integer[] fibonacci(int n) {
        if(dp[n][0] == null || dp[n][1] == null){
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }
}
