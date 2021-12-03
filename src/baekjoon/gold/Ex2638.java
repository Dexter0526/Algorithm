package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 치즈(다시 풀기)
public class Ex2638 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] isVisited;
    public static int[][] cheese;
    public static List<int[]> list = new ArrayList<>();
    public static int count = 0;
    public static int answer = 0;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        cheese = new int[N][M];

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < M; j++){
                cheese[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if(cheese[i][j] == 1) {
                    list.add(new int[]{i, j});
                    count++;
                }
            }
        }

        while (count != 0){
            isVisited = new boolean[N][M];
            dfs(0, 0);
            melt();
            answer++;
        }

        System.out.println(answer);

    }

    private static void dfs(int x, int y){
        isVisited[x][y] = true;

        cheese[x][y] = 2;
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newY >= 0 && newX < N && newY < M){
                if(!isVisited[newX][newY] && cheese[newX][newY] != 1){
                    dfs(newX, newY);
                }
            }
        }
    }

    private static void melt(){
//        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++){
            int[] melt = list.get(i);
            int air = 0;
            for(int j = 0; j < 4; j++){
                int newX = melt[0] + dx[j];
                int newY = melt[1] + dy[j];

                if(cheese[newX][newY] == 2) air++;
            }

            if(air >= 2) {
                list.remove(i);
                cheese[melt[0]][melt[1]] = 0;
                count--;
                i--;
            }
        }
    }
}
