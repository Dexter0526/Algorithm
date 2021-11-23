package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (2)
public class Ex15650 {
    public static int N;
    public static int M;
    public static int[] number;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        number = new int[M];
        dfs(0, 0);
        System.out.println(stringBuilder);
    }

    private static void dfs(int depth, int start){
        if(depth == number.length) {
            for(int i = 0; i < number.length; i++) stringBuilder.append(number[i]).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            number[depth] = i + 1;
            dfs(depth + 1, i + 1);
        }
    }
}
