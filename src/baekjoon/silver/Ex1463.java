package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 1로 만들기
public class Ex1463 {
    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(dpRecursive(n));
    }

    public static int dpRecursive(int n){
        if(dp[n] == null){
            if(n % 6 == 0) dp[n] = Math.min(dpRecursive(n / 3), Math.min(dpRecursive(n / 2), dpRecursive(n - 1))) + 1;
            else if(n % 3 == 0) dp[n] = Math.min(dpRecursive(n / 3), dpRecursive(n - 1)) + 1;
            else if(n % 2 == 0) dp[n] = Math.min(dpRecursive(n / 2), dpRecursive(n - 1)) + 1;
            else dp[n] = dpRecursive(n - 1) + 1;
        }

        return dp[n];
    }
}
