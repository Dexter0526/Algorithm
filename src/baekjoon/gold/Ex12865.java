package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

// 평범한 배낭
public class Ex12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int[][] knapsack = new int[N][2];
        int[][] cache = new int[N][K + 1];

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            knapsack[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            knapsack[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i = 1; i <= K; i++){
            if(knapsack[0][0] > i) continue;

            cache[0][i] = knapsack[0][1];
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j <= K; j++){
                if(knapsack[i][0] > j) {
                    cache[i][j] = cache[i - 1][j];
                    continue;
                }

                int reamingSpace = j - knapsack[i][0];
                int remainingMaxValue = cache[i - 1][reamingSpace];

                cache[i][j] = Math.max(cache[i - 1][j], knapsack[i][1] + remainingMaxValue);
            }
        }
//        for(int i = 0; i < cache.length; i++){
//            System.out.println(Arrays.toString(cache[i]));
//        }

        System.out.println(cache[N - 1][K]);
    }
}
