package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (8)
public class Ex15657 {
    public static int N;
    public static int M;
    public static int[] numbers;
    public static int[] answer;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[N];
        answer = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0, 0);

        System.out.println(stringBuilder);
    }

    private static void dfs(int depth, int start){
        if(depth == M) {
            for(int i = 0; i < depth; i++){
                stringBuilder.append(answer[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            answer[depth] = numbers[i];
            dfs(depth + 1, i);
        }

    }
}
