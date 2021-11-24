package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최단경로
public class Ex1753 {
    public static int V;
    public static int E;
    public static int K;
    public static List<Node>[] list;
    public static int[] minDists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        V = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(bufferedReader.readLine());
        minDists = new int[V + 1];
        list = new List[V + 1];

        for(int i = 1; i <= V; i++){
            minDists[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            list[Integer.parseInt(stringTokenizer.nextToken())]
                    .add(new Node(Integer.parseInt(stringTokenizer.nextToken())
                            , Integer.parseInt(stringTokenizer.nextToken())));
        }

        dijkstra(K);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(minDists[i] == Integer.MAX_VALUE) {
                stringBuilder.append("INF").append("\n");
                continue;
            }
            stringBuilder.append(minDists[i]).append("\n");
        }

        System.out.println(stringBuilder);

    }

    private static void dijkstra(int root){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        HashSet<Integer> discovered = new HashSet<>();
        queue.add(new Node(root, 0));
        minDists[root] = 0;

        while (!queue.isEmpty()){
            Node node = queue.remove();
            int neighbor = node.neighbor;

            if(discovered.contains(neighbor)) continue;
            discovered.add(neighbor);
            for(Node item : list[neighbor]){
                int newDistance = minDists[neighbor] + item.weight;
                if(minDists[item.neighbor] > newDistance){
                    minDists[item.neighbor] = newDistance;
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
