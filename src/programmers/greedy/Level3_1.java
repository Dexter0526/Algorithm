package programmers.greedy;

import java.util.*;

// 섬 연결하기
public class Level3_1 {
//    public static Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
//    public static List<Integer> processed = new ArrayList<>();

    public static int[] parents;

    public static void main(String[] args) {
//        n	costs	return
//4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
        int n = 4;
        int[][] costs = {{0, 1, 1},{0, 2, 2},{1, 2, 5},{1, 3, 1}, {2, 3, 8}};
        solution(n, costs);
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int total = 0;

        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2 [2]);

        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        for(int[] node: costs){
            int from = node[0];
            int to = node[1];
            int cost = node[2];



        }

        return answer;
    }

//    public static int solution(int n, int[][] costs) {
//        int answer = 0;
//
//
//        Map<Integer, Integer> weights = new HashMap<>();
//        Map<Integer, Integer> parents = new HashMap<>();
//
//        for(int i = 0; i < n; i++){
//            graph.put(i, new HashMap<>());
//            weights.put(i, Integer.MAX_VALUE);
//            parents.put(i, null);
//        }
//        weights.remove(0);
//        parents.remove(0);
//
//        for(int i = 0; i < costs.length; i++){
//            graph.get(costs[i][0]).put(costs[i][1], costs[i][2]);
//            if(costs[i][0] == 0){
//                weights.put(costs[i][1], costs[i][2]);
//                parents.put(costs[i][1], 0);
//            }
//        }
//
////        콘솔
//        System.out.println("그래프 ::: " + graph.toString());
//        System.out.println("비용 ::: " + weights.toString());
//        System.out.println("부모 ::: " + parents.toString());
//
//        return answer;
//    }
    
}
