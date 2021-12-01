package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

// N과 M (12)
public class Ex15666 {
    public static int[] number;
    public static int[] answer;
    public static int N;
    public static int M;
    public static LinkedHashSet<String> printAnswer = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        number = new int[N];
        answer = new int[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(number);

        dfs(0, 0);
        for(String item : printAnswer){
            System.out.println(item);
        }

    }

    private static void dfs(int depth, int index){
        if(depth == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < M; i++){
                stringBuilder.append(answer[i]).append(" ");
            }
            printAnswer.add(stringBuilder.toString());
            return;
        }

        for(int i = index; i < N; i++){
            answer[depth] = number[i];
            dfs(depth + 1, i);
        }
    }
}
