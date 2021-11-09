package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class Ex7569 {
    public static int M;
    public static int N;
    public static int H;
    public static int[][][] matrix;
    public static boolean[][][] isVisit;
    public static Queue<int[]> queue = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, -1, 1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());
        matrix = new int[H][N][M];
        isVisit = new boolean[H][N][M];
        int count = 0;

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int k = 0; k < M; k++){
                    matrix[i][j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    if(matrix[i][j][k] == 1){
                        queue.add(new int[]{i, j, k});
                        isVisit[i][j][k] = true;
                    }
                }
            }
        }

        bfs();

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(matrix[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    count = Math.max(matrix[i][j][k], count);
                }
            }
        }

        System.out.println(count - 1);

    }

    private static void bfs(){
        while (!queue.isEmpty()){
            int[] temp = queue.remove();
            for(int i = 0; i < 6; i++){
                int x = dx[i] + temp[1];
                int y = dy[i] + temp[2];
                int z = dz[i] + temp[0];

                if(x >= 0 && y >= 0 && z >= 0 && x < N && y < M && z < H){
                    if(matrix[z][x][y] == 0 && !isVisit[z][x][y]){
                        queue.add(new int[]{z, x, y});
                        isVisit[z][x][y] = true;
                        matrix[z][x][y] = matrix[temp[0]][temp[1]][temp[2]] + 1;
                    }
                }
            }
        }
    }
}
