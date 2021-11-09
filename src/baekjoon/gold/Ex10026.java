package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 적록색약
public class Ex10026 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[] answer;
    public static boolean[][] isVisit;
    public static int N;
    public static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        answer = new int[2];
        matrix = new char[N][N];
        isVisit = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String line = bufferedReader.readLine();
            for(int j = 0; j < N; j++){
                matrix[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!isVisit[i][j]){
                    answer[0]++;
                    isVisit[i][j] = true;
                    bfs(i, j, true);
                }
            }
        }
        isVisit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!isVisit[i][j]){
                    answer[1]++;
                    isVisit[i][j] = true;
                    bfs(i, j, false);
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }

    private static void bfs(int i, int j, boolean normal){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        if(!normal && matrix[i][j] == 'R') matrix[i][j] = 'G';

        while (!queue.isEmpty()){
            int[] temp = queue.remove();
            for(int k = 0; k < 4; k++){
                int newX = dx[k] + temp[0];
                int newY = dy[k] + temp[1];

                if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                    if(normal){
                        if(matrix[i][j] == matrix[newX][newY] && !isVisit[newX][newY]){
                            isVisit[newX][newY] = true;
                            queue.add(new int[]{newX, newY});
                        }
                    }else{
                        if(matrix[newX][newY] == 'R') matrix[newX][newY] = 'G';
                        if(matrix[temp[0]][temp[1]] == matrix[newX][newY] && !isVisit[newX][newY]){
                            isVisit[newX][newY] = true;
                            queue.add(new int[]{newX, newY});
                        }
                    }

                }
            }
        }
    }
}
