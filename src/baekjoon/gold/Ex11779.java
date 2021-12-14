package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소비용 구하기 2
public class Ex11779 {
    public static ArrayList<Node>[] bus;
    public static int[] dist;
    public static int[] route;
    public static final int INF = 1000 * 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        bus = new ArrayList[n + 1];
        dist = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(dist, INF);

        for(int i = 0; i <= n; i++){
            bus[i] = new ArrayList<>();
        }

        while (m --> 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            bus[start].add(new Node(end, cost));
        }

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());

        dijkstra(start, end);
        Stack<Integer> stack = new Stack<>();
        int now = end;

        while (now != start){
            stack.push(now);
            now = route[now];
        }
        stack.push(start);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dist[end]).append("\n");
        stringBuilder.append(stack.size()).append("\n");

        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop()).append(" ");
        }

        System.out.println(stringBuilder);
    }

    private static void dijkstra(int start, int end){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> discovered = new HashSet<>();

        priorityQueue.add(new Node(start, 0));
        dist[start] = 0;

        while (!priorityQueue.isEmpty()){
            Node now = priorityQueue.remove();

            if(discovered.contains(now.end)) continue;
            discovered.add(now.end);

//            System.out.println(now.end);

            for(Node node : bus[now.end]){
                if(dist[node.end] > dist[now.end] + node.weight){
                    int cost = dist[now.end] + node.weight;
                    dist[node.end] = cost;
                    priorityQueue.add(new Node(node.end, cost));
                    route[node.end] = now.end;
//                    System.out.println(now.end + " " + node.end + " " + dist[node.end]);
                }
            }
        }

    }

    public static class Node implements Comparable<Node>{
        private int end;
        private int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
