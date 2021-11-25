package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
public class Ex2206 {
    public static int N;
    public static int M;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] matrix;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        matrix = new int[N][M];


        for(int i = 0; i < N; i++){
            String line = bufferedReader.readLine();
            for(int j = 0; j < M; j++){
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs(){
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(matrix[i]));
//        }
//        System.out.println("======================");

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] isVisit = new boolean[N][M][2];

        queue.add(new int[]{0, 0, 1, 0});
        isVisit[0][0][0] = true;
        isVisit[0][0][1] = true;

        while (!queue.isEmpty()){
            int[] now = queue.remove();
            if(now[0] == N - 1 && now[1] == M - 1) {
                answer = now[2];
//                System.out.println(answer);
                return;
            }
            for(int i = 0; i < 4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >= 0 && y >= 0 && x < N && y < M){
                    if(matrix[x][y] == 0 && !isVisit[x][y][now[3]]){
                        isVisit[x][y][now[3]] = true;
                        queue.add(new int[]{x, y, now[2] + 1, now[3]});
                    }else if(now[3] == 0 && !isVisit[x][y][1]){
                        isVisit[x][y][1] = true;
                        queue.add(new int[]{x, y, now[2] + 1, 1});
                    }
                }
            }
        }
    }
}
