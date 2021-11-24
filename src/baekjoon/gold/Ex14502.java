package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소
public class Ex14502 {
    public static final int BLANK = 0;
    public static final int WALL = 1;
    public static final int VIRUS = 2;
    public static int[][] map;
    public static int N;
    public static int M;
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    public static int safe = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dfs(0, map);
        System.out.println(safe);
    }

//    벽 세우기
    private static void dfs(int depth, int[][] spread){
        if(depth == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < spread.length; i++){
            for(int j = 0; j < spread[i].length; j++){
                if(spread[i][j] == BLANK){
                    spread[i][j] = WALL;
                    dfs(depth + 1, spread);
                    spread[i][j] = BLANK;
                }
            }
        }

    }

//    감염
    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int[][] spread = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) spread[i][j] = map[i][j];
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(spread[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()){
            int[] location = queue.remove();

            for(int i = 0; i < 4; i++){
                int x = location[0] + dx[i];
                int y = location[1] + dy[i];

                if(x >= 0 && y >= 0 && x < spread.length && y < spread[x].length){
                    if(spread[x][y] == BLANK){
                        spread[x][y] = VIRUS;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }

        safeZone(spread);
    }

//    안전 구역 카운트
    private static void safeZone(int[][] spread){
        int count = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(spread[i][j] == BLANK) count++;
            }
        }

        for(int i = 0; i < spread.length; i++){
            System.out.println(Arrays.toString(spread[i]));
        }
        System.out.println("==================================================");

        safe = Math.max(safe, count);
    }
}
