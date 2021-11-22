package programmers.graph;

import java.util.Arrays;

// 순위
public class Level3_2 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(solution(n, results));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] matrix = new boolean[n + 1][n + 1];

        for(int i = 0; i < results.length; i++){
            matrix[results[i][0]][results[i][1]] = true;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(i == j) continue;
                    if(matrix[i][k] && matrix[k][j]) matrix[i][j] = true;
                }
            }
        }
        for(int i = 0; i <= n; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(matrix[i][j] || matrix[j][i]) count++;
            }

            if(count == n - 1) answer++;
        }

        return answer;
    }
}
