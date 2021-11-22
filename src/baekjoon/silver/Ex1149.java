package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리
public class Ex1149 {
    public static int N;
    public static int[][] RGB;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        RGB = new int[N][3];
        dp = new int[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            RGB[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            RGB[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            RGB[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }

//        초기화 0 : R, 1 : G, 2 : B
        for(int i = 0; i < 3; i++){
            dp[0][i] = RGB[0][i];
        }

        System.out.println(Math.min(dfs(N - 1, 0), Math.min(dfs(N - 1, 1), dfs(N - 1, 2))));
    }


    private static int dfs(int depth, int color){
        if(dp[depth][color] == 0 && depth > 0){
            switch (color){
                case 0:
                    dp[depth][color] = Math.min(dfs(depth - 1, 1), dfs(depth - 1, 2)) + RGB[depth][0];
                    break;
                case 1:
                    dp[depth][color] = Math.min(dfs(depth - 1, 0), dfs(depth - 1, 2)) + RGB[depth][1];
                    break;
                case 2:
                    dp[depth][color] = Math.min(dfs(depth - 1, 0), dfs(depth - 1, 1)) + RGB[depth][2];
                    break;
                default:
                    break;
            }
        }

        return dp[depth][color];
    }
}
