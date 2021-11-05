package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 덩치
public class Ex7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] person = new int[N][2];
        int[] answer = new int[N];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            person[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            person[i][1] = Integer.parseInt(stringTokenizer.nextToken());

        }

        for(int i = 0; i < N; i++){
            int k = 1;
            for(int j = 0; j < N; j++){
                if(i == j) continue;

                if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) k++;
            }

            answer[i] = k;
            stringBuilder.append(k).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
