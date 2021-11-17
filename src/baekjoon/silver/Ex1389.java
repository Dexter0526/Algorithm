package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 케빈 베이컨의 6단계 법칙
public class Ex1389 {
    public static List<Integer>[] relationship;
    public static int N;
    public static int M;
    public static int maxDepth = Integer.MAX_VALUE;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        answer = N + 1;
        relationship = new ArrayList[N + 1];

        for(int i = 0; i < M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            if(relationship[A] == null) relationship[A] = new ArrayList<>();
            if(relationship[B] == null) relationship[B] = new ArrayList<>();

            relationship[A].add(B);
            relationship[B].add(A);
        }

        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 1; j <= N; j++){
                if(i == j) continue;

                int temp = bfs(i, j);
                sum += temp;
            }

            if(sum > maxDepth) continue;
            if(sum < maxDepth) answer = i;
            else answer = Math.min(answer, i);

            maxDepth = sum;
        }

        System.out.println(answer);
    }

    private static int bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> discovered = new HashSet<>();
        int[] count = new int[N + 1];
        queue.add(start);
        discovered.add(start);

        while (!queue.isEmpty()){
            int now = queue.remove();

            for(int i = 0; i < relationship[now].size(); i++){
                if(!discovered.contains(relationship[now].get(i))){
                    if(end == relationship[now].get(i)) return count[now] + 1;

                    discovered.add(relationship[now].get(i));
                    queue.add(relationship[now].get(i));
                    count[relationship[now].get(i)] = count[now] + 1;
                }
            }
        }

        return 0;
    }
}
