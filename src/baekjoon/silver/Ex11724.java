package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연결 요소의 개수
public class Ex11724 {
    public static int N;
    public static int M;
    public static int count;
    public static HashSet<Integer> discovered;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        LinkedList<Integer>[] linkedLists = new LinkedList[N + 1];
        count = 0;
        discovered = new HashSet<>();

        for(int i = 0; i < M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node = Integer.parseInt(stringTokenizer.nextToken());
            int next = Integer.parseInt(stringTokenizer.nextToken());

            if(linkedLists[node] == null) linkedLists[node] = new LinkedList<>();
            if(linkedLists[next] == null) linkedLists[next] = new LinkedList<>();

            linkedLists[node].add(next);
            linkedLists[next].add(node);
        }

        for(int i = 1; i <= N; i++){
            if(!discovered.contains(i)){
                count++;
                discovered.add(i);
//                bfs(linkedLists, i);
                dfs(linkedLists, i);
            }
        }

        System.out.println(count);
    }

    private static void bfs(LinkedList<Integer>[] linkedLists, int number){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(number);

        while (!queue.isEmpty()){
            int node = queue.remove();
            LinkedList<Integer> neighbors = linkedLists[node];
            if(neighbors == null) continue;
            for(int i = 0; i < neighbors.size(); i++){
                if(!discovered.contains(neighbors.get(i))){
                    queue.add(neighbors.get(i));
                    discovered.add(neighbors.get(i));
                }
            }
        }
    }

    private static void dfs(LinkedList<Integer>[] linkedLists, int number){
        if(linkedLists[number] == null) return;
        discovered.add(number);

        LinkedList<Integer> neighbors = linkedLists[number];
        for(int i = 0; i < neighbors.size(); i++){
            if(!discovered.contains(neighbors.get(i))){
                dfs(linkedLists, neighbors.get(i));
            }
        }
    }
}
