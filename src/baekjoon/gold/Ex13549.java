package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숨바꼭질 3
public class Ex13549 {
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        bfs(N, K);
        System.out.println(answer);
    }

    private static void bfs(int start, int end){
        HashSet<Integer> discovered = new HashSet<>();
//        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()){
            int[] times = queue.remove();
            discovered.add(times[0]);

            if(times[0] == end) {
                answer = Math.min(answer, times[1]);
            }

            if(times[0] * 2 <= 100_000 && !discovered.contains(times[0] * 2)){
                queue.add(new int[]{times[0] * 2, times[1]});
            }
            if(times[0] + 1 <= 100_000 && !discovered.contains(times[0] + 1)){
                queue.add(new int[]{times[0] + 1, times[1] + 1});
            }
            if(times[0] - 1 >= 0 && !discovered.contains(times[0] - 1)){
                queue.add(new int[]{times[0] - 1, times[1] + 1});
            }

        }
    }
}
