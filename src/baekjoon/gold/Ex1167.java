package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름
public class Ex1167 {
    public static List<Node>[] lists;
    public static HashSet<Integer> discovered = new HashSet<>();
    public static int maxWeight;
    public static int startNode;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(bufferedReader.readLine());
        lists = new List[V + 1];

        for(int i = 1; i <= V; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 1; i <= V; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            while (stringTokenizer.hasMoreTokens()){
                int neighbor = Integer.parseInt(stringTokenizer.nextToken());
                if(neighbor == -1) break;
                int weight = Integer.parseInt(stringTokenizer.nextToken());
                lists[start].add(new Node(neighbor, weight));
                lists[neighbor].add(new Node(start, weight));
            }
        }
        discovered.add(1);
        dfs(1, 0);
        discovered.clear();
        discovered.add(startNode);
        dfs(startNode, 0);
        System.out.println(maxWeight);
    }

    private static void dfs(int node, int weight){
        for(Node item : lists[node]){
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
    public static class Node implements Comparable<Node>{
        private int neighbor;
        private int weight;

        public Node(int neighbor, int weight){
            this.neighbor = neighbor;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }
}
