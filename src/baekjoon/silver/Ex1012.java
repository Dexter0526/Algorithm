package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
public class Ex1012 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] matrix;
    public static boolean[][] isVisit;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();


        for(int i = 0; i < T; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());
            matrix = new int[M][N];
            isVisit = new boolean[M][N];
            count = 0;

            for(int j = 0; j < K; j++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                matrix[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())] = 1;
            }

            if(i % 2 == 0){ // BFS
                for(int j = 0; j < M; j++){
                    for(int k = 0; k < N; k++){
                        if(matrix[j][k] == 1 && !isVisit[j][k]){
                            count++;
                            bfs(j, k);
                        }
                    }
                }
            }else{ // DFS
                for(int j = 0; j < M; j++){
                    for(int k = 0; k < N; k++){
                        if(matrix[j][k] == 1 && !isVisit[j][k]){
                            count++;
                            dfs(j, k);
                        }
                    }
                }
            }



            stringBuilder.append(count).append("\n");

        }

        System.out.println(stringBuilder);
    }

    private static void bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        isVisit[i][j] = true;


        while (!queue.isEmpty()){
            int[] temp = queue.remove();
            for(int k = 0; k < 4; k++){
                int newX = dx[k] + temp[0];
                int newY = dy[k] + temp[1];

                if(newX >= 0 && newY >= 0 && newX < matrix.length && newY < matrix[i].length){
                    if(matrix[newX][newY] == 1 && !isVisit[newX][newY]){
                        queue.add(new int[]{newX, newY});
                        isVisit[newX][newY] = true;
                    }
                }
            }
        }
    }

    private static void dfs(int i, int j){
        isVisit[i][j] = true;

        for(int k = 0; k < 4; k++){
            int newX = dx[k] + i;
            int newY = dy[k] + j;

            if(newX >= 0 && newY >= 0 && newX < matrix.length && newY < matrix[i].length){
                if(matrix[newX][newY] == 1 && !isVisit[newX][newY]){
                    dfs(newX, newY);
                }
            }
        }
    }
}
