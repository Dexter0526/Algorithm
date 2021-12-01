package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 행렬 제곱(분할 정복)
public class Ex10830 {
    public static int N;

    public static final int MOD = 1000;
    public static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());

        matrix = new int[N][N];

//        입력
        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken()) % MOD;
            }
        }

        matrix = dividePow(B);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                stringBuilder.append(matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int[][] dividePow(long exp){
        if(exp == 1) return matrix;

        int[][] result = dividePow(exp / 2);
        result = multiplyMatrix(result, result);

        if(exp % 2 == 1) result = multiplyMatrix(result, matrix);

        return result;
    }

    private static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2){
        int[][] result = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
