package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 특정한 최단 경로
public class Ex1504 {
    public static int N;
    public static int E;
    public static List<Node>[] road;
    public static final int INF = 200_000_000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());
        road = new List[N + 1];

        for(int i = 0; i <= N; i++){
            road[i] = new ArrayList();
        }

        while (E --> 0){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            road[a].add(new Node(b, c));
            road[b].add(new Node(a, c));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int v1 = Integer.parseInt(stringTokenizer.nextToken());
        int v2 = Integer.parseInt(stringTokenizer.nextToken());

        int[] startDistance = dijkstra(1);
        int[] v1Distance = dijkstra(v1);
        int[] v2Distance = dijkstra(v2);

        int answer = Math.min(startDistance[v1] + v1Distance[v2] + v2Distance[N]
        , startDistance[v2] + v2Distance[v1] + v1Distance[N]);

        if(answer >= INF) answer = -1;
        System.out.println(answer);

//        플로이드 워셜 가능 유무 확인!!
//        for(int k = 1; k <= N; k++){
//            for(int i = 1; i <= N; i++){
//                for(int j = 1; j <= N; j++){
//                    if(i == j) continue;
//                    if(matrix[i][k] < Integer.MAX_VALUE && matrix[k][j] < Integer.MAX_VALUE){
//                        matrix[i][j] = Math.max(matrix[i][j], matrix[i][k] + matrix[k][j]);
//                    }
//                }
//            }
//        }
//
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(matrix[i]));
//        }
    }

    private static int[] dijkstra(int root){
        int[] minDist = new int[N + 1];
        HashSet<Integer> discovered = new HashSet<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Arrays.fill(minDist, INF);
        priorityQueue.add(new Node(root, 0));
        minDist[root] = 0;

        while (!priorityQueue.isEmpty()){
            Node now = priorityQueue.remove();
            if(discovered.contains(now.neighbor)) continue;
            discovered.add(now.neighbor);

            for(Node node : road[now.neighbor]){
                int newDistance = minDist[now.neighbor] + node.weight;
                if(minDist[node.neighbor] > newDistance){
                    minDist[node.neighbor] = newDistance;
                    priorityQueue.add(new Node(node.neighbor, newDistance));
                }
            }
        }

        return minDist;
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
