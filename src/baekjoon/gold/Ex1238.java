package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 파티
public class Ex1238 {
    public static int N;
    public static int M;
    public static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());
        List<Node>[] list = new List[N + 1];
        List<Node>[] reversList = new List[N + 1];

        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList();
            reversList[i] = new ArrayList();
        }

        for(int i = 0; i < M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            list[start].add(new Node(end, weight));
            reversList[end].add(new Node(start, weight));
        }

        int[] dist1 = dijkstra(X, list);
        int[] dist2 = dijkstra(X, reversList);
        int answer = 0;

        for(int i = 1; i <= N; i++){
            answer = Math.max(answer, dist1[i] + dist2[i]);
        }
        System.out.println(answer);
    }

    private static int[] dijkstra(int root, List<Node>[] list){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> discovered = new HashSet<>();
        int[] minDists = new int[N + 1];
        Arrays.fill(minDists, Integer.MAX_VALUE);
        priorityQueue.add(new Node(root, 0));
        minDists[root] = 0;

        while (!priorityQueue.isEmpty()){
            Node now = priorityQueue.remove();
            if(discovered.contains(now.neighbor)) continue;
            discovered.add(now.neighbor);

            for(Node node : list[now.neighbor]){
                int newDistance = minDists[now.neighbor] + node.weight;
                if(minDists[node.neighbor] > newDistance){
                    minDists[node.neighbor] = newDistance;
                    priorityQueue.add(new Node(node.neighbor, newDistance));
                }
            }
        }

//        System.out.println(Arrays.toString(minDists));
        return minDists;

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
            return this.weight - o.weight;
        }
    }
}
