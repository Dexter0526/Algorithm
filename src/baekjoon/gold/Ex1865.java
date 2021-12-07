package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 웜홀
public class Ex1865 {
    public static List<Node>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(bufferedReader.readLine());

        while (TC --> 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
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

        }
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
