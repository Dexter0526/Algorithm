package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// N과 M (5)
public class Ex15654 {
    public static int N;
    public static int M;
    public static int[] numbers;
    public static int[] answer;
    public static HashSet<Integer> discovered = new HashSet<>();
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[N];
        answer = new int[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0);
        System.out.println(stringBuilder);
    }

    private static void dfs(int depth){
        if(depth == M) {
            for(int i = 0; i < answer.length; i++){
                stringBuilder.append(answer[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!discovered.contains(numbers[i])){
                discovered.add(numbers[i]);
                answer[depth] = numbers[i];
                dfs(depth + 1);
                discovered.remove(numbers[i]);
            }
        }
    }
}
