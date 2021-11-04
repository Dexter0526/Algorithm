package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 부녀회장이 될테야
public class Ex2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        int[][] dp = new int[15][15];

        for(int i = 0; i < dp.length; i++){
            dp[0][i] = i;
        }

        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(bufferedReader.readLine());
            int n = Integer.parseInt(bufferedReader.readLine());

            for(int a = 1; a <= k; a++){
                if(dp[a][14] != 0) continue;
                for(int b = 1; b <= n; b++){
                    if(dp[a][b] != 0) continue;

                    dp[a][b] = dp[a][b - 1] + dp[a - 1][b];
                }
            }

            System.out.println(dp[k][n]);
        }
    }
}
