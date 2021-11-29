package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 지름
public class Ex1967 {
    public static int n;
    public static List<Node>[] list;
    public static HashSet<Integer> discovered = new HashSet<>();
    public static int maxWeight;
    public static int startNode;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        list = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        discovered.add(1);
        dfs(1, 0);
        discovered.clear();
        discovered.add(startNode);
        dfs(startNode, 0);
        System.out.println(maxWeight);
    }

    private static void dfs(int node, int weight){
        for(Node item : list[node]){
            if(!discovered.contains(item.neighbor)){
                discovered.add(item.neighbor);
                dfs(item.neighbor, weight + item.weight);
            }
        }

        if(maxWeight < weight){
            maxWeight = weight;
            startNode = node;
        }

    }

    public static class Node{
        private int neighbor;
        private int weight;

        public Node(int neighbor, int weight){
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }
}
