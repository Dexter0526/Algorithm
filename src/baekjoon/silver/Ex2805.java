package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나무 자르기
public class Ex2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

//        나무수
        int N = Integer.parseInt(stringTokenizer.nextToken());
//        가져갈 나무 길이
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] trees = new int[N];
        int answer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < N; i++) trees[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(trees);
        answer = trees[trees.length - 1];

        while (answer >= 0){
            int sum = 0;
            answer--;

            for(int i = N - 1; i >= 0; i--){
                if(answer > trees[i]) break;

                sum += trees[i] - answer;
            }

            if(sum >= M) break;
        }
        System.out.println(answer);
    }
}
