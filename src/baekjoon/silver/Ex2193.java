package baekjoon.silver;

import java.util.Scanner;

// 이친수
public class Ex2193 {
    public static long dp[][] ; // 데이터 타입에 유의한다.

    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        long sum =0;

        dp = new long [n+1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 2; j++) {
                if(j == 0) dp[i][j] = dp[i-1][0] + dp[i-1][1];
                else dp[i][j] = dp[i-1][0];
            }
        }

        for(int i = 0; i < 2; i++) {
            sum += dp[n][i];

        }

        System.out.println(sum);

    }
}
