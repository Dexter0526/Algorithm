package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수 삼각형
public class Ex1932 {
    public static int n;
    public static int[][] matrix;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[n][n];
        dp = new int[n][n];
        
//        입력
        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int j = 0;
            while (stringTokenizer.hasMoreTokens()){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(i == n - 1) dp[i][j] = matrix[i][j];
                j++;
            }
        }

//        for문 사용
//        for(int i = n - 2; i >= 0; i--){
//            for(int j = 0; j <= i; j++){
//                matrix[i][j] += Math.max(matrix[i + 1][j], matrix[i + 1][j + 1]);
//            }
//        }
//        System.out.println(matrix[0][0]);

        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    private static int dfs(int depth, int index){
        if(depth < n - 1 && dp[depth][index] == 0){
            dp[depth][index] = Math.max(dfs(depth + 1, index), dfs(depth + 1, index + 1)) + matrix[depth][index];
        }
        System.out.println(depth + " " + index);
        return dp[depth][index];
    }

}
