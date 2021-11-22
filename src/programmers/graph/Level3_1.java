package programmers.graph;

import java.util.*;

// 가장 먼 노드
public class Level3_1 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(6, edge));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        HashMap<Integer, HashSet<Integer>> nodes = new HashMap<>();
        HashSet<Integer> discovered = new HashSet<>();
        int[] distance = new int[n + 1];

        for(int i = 0; i < edge.length; i++){
            HashSet<Integer> neighbor = new HashSet<>();
            if(nodes.containsKey(edge[i][0])){
                neighbor = nodes.get(edge[i][0]);
            }
            neighbor.add(edge[i][1]);
            nodes.put(edge[i][0], neighbor);

            neighbor = new HashSet<>();
            if(nodes.containsKey(edge[i][1])){
                neighbor = nodes.get(edge[i][1]);
            }
            neighbor.add(edge[i][0]);
            nodes.put(edge[i][1], neighbor);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        discovered.add(1);
        distance[1] = 1;

//        System.out.println(nodes.get(1));

        while (!queue.isEmpty()){
            int node = queue.remove();

            HashSet<Integer> neighbor = nodes.get(node);

            if(neighbor != null){
                for(int number : neighbor){
                    if(!discovered.contains(number)){
                        distance[number] = distance[node] + 1;
                        discovered.add(number);
                        queue.add(number);
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(distance));
        Arrays.sort(distance);
        int max = distance[distance.length - 1];

        for(int i = distance.length - 2; i >= 0; i--){
            if(max > distance[i]) break;

            answer++;
        }

        return answer;
    }
}
