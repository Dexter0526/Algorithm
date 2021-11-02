package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (1)
public class Ex15649 {
    private static boolean[] discovered;
    private static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        discovered = new boolean[n];
        number = new int[m];

        dfs(0);
    }

    private static void dfs(int depth){
        if(depth == number.length) {
            for(int i = 0; i < number.length; i++) System.out.print(number[i] + " ");
            System.out.println();
            return;
        }

        for(int i = 0; i < discovered.length; i++){
            if(!discovered[i]){
                number[depth] = i + 1;
                discovered[i] = true;
                dfs(depth + 1);
                discovered[i] = false;
            }
        }
    }
}
