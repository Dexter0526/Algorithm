package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS와 BFS
public class Ex1260 {
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int start = Integer.parseInt(stringTokenizer.nextToken());


        LinkedList<Integer>[] nodes = new LinkedList[N + 1];

        Set<Integer> discovered = new HashSet<>();

        for(int i = 0; i < M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int node = Integer.parseInt(stringTokenizer.nextToken());
            int next = Integer.parseInt(stringTokenizer.nextToken());

            if(nodes[node] == null){
                LinkedList<Integer> temp = new LinkedList<>();
                nodes[node] = temp;
            }

            if(nodes[next] == null){
                LinkedList<Integer> temp = new LinkedList<>();
                nodes[next] = temp;
            }
            nodes[node].add(next);
            nodes[next].add(node);
        }

        dfs(nodes, start, discovered);
        bfs(nodes, start, discovered);

        System.out.println(stringBuilder);

    }

    private static void dfs(LinkedList<Integer>[] nodes, int number, Set<Integer> discovered){
        LinkedList<Integer> temp = nodes[number];
        stringBuilder.append(number).append(" ");
        discovered.add(number);
        if(temp == null) return;
        Collections.sort(temp);

        for(int i = 0; i < temp.size(); i++){
            if(!discovered.contains(temp.get(i))){
                dfs(nodes, temp.get(i), discovered);
            }
        }

    }

    private static void bfs(LinkedList<Integer>[] nodes, int number, Set<Integer> discovered){
        stringBuilder.append("\n");
        Queue<Integer> queue = new LinkedList<>();
        discovered.clear();
        queue.add(number);
        discovered.add(number);

        while (!queue.isEmpty()){
            Integer node = queue.remove();
            stringBuilder.append(node).append(" ");

            List<Integer> temp = nodes[node];
            if(temp == null) continue;
            Collections.sort(temp);

            for(int i = 0; i < temp.size(); i++){
                if(!discovered.contains(temp.get(i))){
                    queue.add(temp.get(i));
                    discovered.add(temp.get(i));
                }
            }
        }

    }
}
