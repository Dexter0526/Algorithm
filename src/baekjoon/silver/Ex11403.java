package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

// 경로 찾기
public class Ex11403 {
    public static int N;
    public static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[N][N];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int index = 0;
            while (stringTokenizer.hasMoreTokens()){
                int number = Integer.parseInt(stringTokenizer.nextToken());
                matrix[i][index] = number;
                index++;
            }
        }

//        bfs
//        for(int i = 0; i < N; i++){
//            bfs(i);
//        }

//        플로이드-와샬 알고리즘
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                if(k == i) continue;
                for(int j = 0; j < N; j++){
                    if(matrix[i][k] == 1 && matrix[k][j] == 1){
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                stringBuilder.append(matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> discovered = new HashSet<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int node = queue.remove();

            for(int i = 0; i < N; i++){
                if(matrix[node][i] == 1 && !discovered.contains(i)){
                    queue.add(i);
                    discovered.add(i);
                    matrix[start][i] = 1;
                }
            }
        }
    }
}
