package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 블랙잭
public class Ex2798 {
    private static int answer = 0;
    private static int m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        int[] cards = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        HashSet<Integer> discovered = new HashSet<>();

        for(int i = 0; i < n; i++){
            cards[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        dfs(cards, 0, discovered, 0);

        System.out.println(answer);

    }

    private static void dfs(int[] cards, int depth, HashSet<Integer> discovered, int sum){
        if(depth == 3){
            if(sum <= m) answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < cards.length; i++){
            if(!discovered.contains(cards[i])){

                if(sum + cards[i] > m) continue;

                discovered.add(cards[i]);
                dfs(cards, depth + 1, discovered, sum + cards[i]);
                discovered.remove(cards[i]);
            }
        }
    }
}
