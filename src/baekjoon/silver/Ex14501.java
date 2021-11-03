package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퇴사
public class Ex14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[n + 1];
        int[] days = new int[n];
        int[] cost = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            days[i] = Integer.parseInt(stringTokenizer.nextToken());
            cost[i] = Integer.parseInt(stringTokenizer.nextToken());

        }

        for(int i = 0; i < n; i++){
            if(i + days[i] <= n){
                dp[i + days[i]] = Math.max(dp[i + days[i]], dp[i] + cost[i]);
            }else{
                dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            }
        }

        System.out.println(Arrays.toString(dp));

        System.out.println("=============================");

        System.out.println(dp[n]);
    }
}
