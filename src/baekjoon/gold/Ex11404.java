package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드
public class Ex11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[n][n];
        int m = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) matrix[i][j] = 0;
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < m; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            matrix[start - 1][end - 1] = Math.min(matrix[start - 1][end - 1], weight);
        }

//        입력 확인
//        for(int i = 0; i < n; i++){
//            System.out.println(Arrays.toString(matrix[i]));
//        }
//        System.out.println("======================");

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == j) continue;
                    if(matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE){
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        //        입력 확인
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] >= Integer.MAX_VALUE) matrix[i][j] = 0;
                stringBuilder.append(matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);

    }
}
