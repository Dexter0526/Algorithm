package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서강그라운드
public class Ex14938 {
    public static int[] items;
    public static int[][] graph;
    public static final int MAX_VALUE = 15 * 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int answer = 0;

        items = new int[n + 1];
        graph = new int[n + 1][n + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i <= n; i++){
            items[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                graph[i][j] = MAX_VALUE;
            }
        }

        for(int i = 0; i < r; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int l = Integer.parseInt(stringTokenizer.nextToken());

            graph[a][b] = l;
            graph[b][a] = l;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(i == j) continue;

                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            int max = items[i];
            for(int j = 1; j <= n; j++){
                if(graph[i][j] <= m) max += items[j];
            }

            answer = Math.max(max, answer);
        }

        System.out.println(answer);
    }
}
