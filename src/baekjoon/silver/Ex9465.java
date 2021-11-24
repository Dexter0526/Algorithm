package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스티커
public class Ex9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (T --> 0){
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] sticker = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for(int i = 0; i < 2; i++){
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j = 1; j <= n; j++){
                    sticker[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for(int i = 2; i <= n; i++){
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }
            stringBuilder.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
