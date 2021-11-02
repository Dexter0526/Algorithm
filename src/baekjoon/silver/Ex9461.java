package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 파도반 수열
public class Ex9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        Long[] dp = new Long[101];

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;


        for(int i = 0; i < n; i++){
            int number = Integer.parseInt(bufferedReader.readLine());

            for(int j = 4; j <= number; j++){
                if(dp[j] == null) dp[j] = dp[j -2] + dp[j - 3];
            }

            System.out.println(dp[number]);
        }
    }
}
