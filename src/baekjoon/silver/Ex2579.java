package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단 오르기
public class Ex2579 {
    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n + 1];
        dp = new Integer[n + 1];

        for(int i = 1; i <= n; i++){
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        dp[0] = numbers[0];
        dp[1] = numbers[1];
        if(n >= 2){
            dp[2] = numbers[1] + numbers[2];
        }

        System.out.println(dfs(numbers, n));
    }

    private static int dfs(int[] numbers, int n){
        if(dp[n] == null){
            dp[n] = Math.max(dfs(numbers, n - 2), dfs(numbers, n - 3) + numbers[n - 1]) + numbers[n];
        }
        return dp[n];
    }


}
