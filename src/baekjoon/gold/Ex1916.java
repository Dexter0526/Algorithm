package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소비용 구하기
public class Ex1916 {
    public static int N;
    public static int M;
    public static int[] minDist;
    public static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());
        minDist = new int[N + 1];
        list = new List[N + 1];

        for(int i = 0; i <= N; i++){
            minDist[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }

        while (M --> 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            list[start].add(new Node(end, weight));
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());
        dijkstra(start);

        System.out.println(minDist[end]);
    }

    private static void dijkstra(int root){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        HashSet<Integer> discovered = new HashSet<>();
        queue.add(new Node(root, 0));
        minDist[root] = 0;

        while (!queue.isEmpty()){
            Node node = queue.remove();
            int neighbor = node.neighbor;

            if(discovered.contains(neighbor)) continue;
            discovered.add(neighbor);
            for(Node item : list[neighbor]){
                int newDistance = minDist[neighbor] + item.weight;
                if(minDist[item.neighbor] > newDistance){
                    minDist[item.neighbor] = newDistance;
                    queue.add(new Node(item.neighbor, newDistance));
                }
            }

        }

    }

    public static class Node implements Comparable<Node>{
        private int neighbor;
        private int weight;

        public Node(int neighbor, int weight){
            this.neighbor = neighbor;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getNeighbor() {
            return neighbor;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
