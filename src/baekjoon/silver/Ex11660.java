package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 5
public class Ex11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] matrix = new int[N + 1][N + 1];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 1; i <= N; i++){
            int sum = 0;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 1; j <= N; j++){
                sum += Integer.parseInt(stringTokenizer.nextToken());
                matrix[i][j] = sum;
            }
        }

        for(int i = 0; i < M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            int answer = 0;
            for(int j = x1; j <= x2; j++){
                answer += matrix[j][y2] - matrix[j][y1];
            }
            stringBuilder.append(answer).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
