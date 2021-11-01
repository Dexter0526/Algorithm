package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 바이러스
public class Ex2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> discovered = new HashSet();
        int[][] matrix = new int[n + 1][n + 1];
        int answer = 0;

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int node = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            matrix[node][next] = matrix[next][node] = 1;
        }


        queue.add(1);
        discovered.add(1);

        while (!queue.isEmpty()){
            int temp = queue.remove();

            for(int i = 1; i <= n; i++){
                if(matrix[temp][i] == 1 && !discovered.contains(i)){
                    discovered.add(i);
                    queue.add(i);
                    answer++;
                }
            }

        }
        System.out.println(answer);
    }
}
