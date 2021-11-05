package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마인크래프트
public class Ex18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int[][] matrix = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                min = Math.min(min, matrix[i][j]);
                max = Math.max(max, matrix[i][j]);
            }
        }

        int time = Integer.MAX_VALUE;
        int height = -1;

        for(int i = min; i <= max; i++){
            int count = 0;
            int bag = B;

            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    int diff = matrix[j][k] - i;

                    if(diff > 0){
                        bag += Math.abs(diff);
                        count += Math.abs(diff) * 2;
                    }else if(diff < 0){
                        bag -= Math.abs(diff);
                        count += Math.abs(diff);
                    }
                }
            }

            if(count <= time && bag >= 0){
                time = count;
                height = i;
            }

        }

        System.out.println(time + " " + height);
    }
}
