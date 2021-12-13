package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 웜홀
public class Ex1865 {
    public static List<Node>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

//        테스트케이스의 개수
        int TC = Integer.parseInt(bufferedReader.readLine());

        while (TC --> 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//            지점의 수
            int N = Integer.parseInt(stringTokenizer.nextToken());
//            도로의 개수
            int M = Integer.parseInt(stringTokenizer.nextToken());
//            웜홀의 개수
            int W = Integer.parseInt(stringTokenizer.nextToken());

            lists = new List[N + 1];
            for(int i = 0; i <= N; i++){
                lists[i] = new ArrayList();
            }

            while (M --> 0){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int S = Integer.parseInt(stringTokenizer.nextToken());
                int E = Integer.parseInt(stringTokenizer.nextToken());
                int T = Integer.parseInt(stringTokenizer.nextToken());

                lists[S].add(new Node(E, T));
                lists[E].add(new Node(S, T));
            }

            while (W --> 0){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int S = Integer.parseInt(stringTokenizer.nextToken());
                int E = Integer.parseInt(stringTokenizer.nextToken());
                int T = Integer.parseInt(stringTokenizer.nextToken());

                lists[S].add(new Node(E, -T));
            }

            if(bellman_ford(N)) stringBuilder.append("YES").append("\n");
            else stringBuilder.append("NO").append("\n");

        }

        System.out.println(stringBuilder);
    }

    private static boolean bellman_ford(int N){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 1000000000);
        dist[0] = 0;
        dist[1] = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j < lists.length; j++){
                for(Node node : lists[j]){
                    if(dist[j] + node.weight < dist[node.end]) dist[node.end] = dist[j] + node.weight;
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        for(int i = 1; i < lists.length; i++){
            for (Node node : lists[i]){
                if(dist[i] + node.weight < dist[node.end]) return true;
            }
        }

        return false;
    }

    public static class Node{
        private int end;
        private int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
}
