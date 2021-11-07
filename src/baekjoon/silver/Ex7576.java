package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class Ex7576 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] isVisit;
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[][] matrix = new int[N][M];
        isVisit = new boolean[N][M];
        int count = 0;

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(matrix[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    isVisit[i][j] = true;
                }
            }
        }

        bfs(matrix);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(matrix[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                count = Math.max(count, matrix[i][j]);
            }
        }

        System.out.println(count - 1);

    }

    public static void bfs(int[][] matrix){
        while (!queue.isEmpty()){
            int[] tomato = queue.remove();
            for(int i = 0; i < 4; i++){
                int newX = dx[i] + tomato[0];
                int newY = dy[i] + tomato[1];

                if(newX >= 0 && newY >= 0 && newX < matrix.length && newY < matrix[tomato[0]].length){
                    if(matrix[newX][newY] == 0 && !isVisit[newX][newY]){
                        isVisit[newX][newY] = true;
                        matrix[newX][newY] = matrix[tomato[0]][tomato[1]] + 1;
                        queue.add(new int[]{newX, newY});

                    }
                }
            }
        }
    }
}
