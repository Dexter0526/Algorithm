package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미세먼지 안녕!
public class Ex17144 {
    public static int R;
    public static int C;
    public static int T;
    public static int[][] matrix;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[] airCleaner = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        T = Integer.parseInt(stringTokenizer.nextToken());
        matrix = new int[R][C];
        int answer = 0;

        for(int i = 0; i < R; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < C; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(matrix[i][j] == -1) {
                    if(airCleaner[0] == 0) airCleaner[0] = i;
                    else airCleaner[1] = i;
                }
            }
        }

        while (T --> 0){
            spread();
            rotate();
        }

//        미세먼지 양
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(matrix[i][j] > 0) answer += matrix[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void spread(){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(matrix[i][j] != 0 && matrix[i][j] != -1) queue.add(new int[]{i, j, matrix[i][j]});
            }
        }

        while (!queue.isEmpty()){
            int[] now = queue.remove();
            if(now[2] < 5) continue;

            for(int i = 0; i < 4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(x >= 0 && y >= 0 && x < R && y < C && matrix[x][y] != -1){
                    matrix[x][y] += now[2] / 5;
                    matrix[now[0]][now[1]] -= now[2] / 5;
                }
            }
        }

    }

    private static void rotate(){
//        왼쪽
        for(int i = airCleaner[0] - 1; i > 0; i--){
            matrix[i][0] = matrix[i - 1][0];
        }

        for(int i = airCleaner[1] + 1; i < R - 1; i++){
            matrix[i][0] = matrix[i + 1][0];
        }

//        상하
        for(int i = 0; i < C - 1; i++){
            matrix[0][i] = matrix[0][i + 1];
            matrix[R - 1][i] = matrix[R - 1][i + 1];
        }

//        오른쪽
        for(int i = 0; i < airCleaner[0]; i++){
            matrix[i][C - 1] = matrix[i + 1][C - 1];
        }
        
        for(int i = R - 1; i > airCleaner[1]; i--){
            matrix[i][C - 1] = matrix[i - 1][C - 1];
        }

//        중앙
        for(int i = C - 1; i > 0; i--){
            matrix[airCleaner[0]][i] = matrix[airCleaner[0]][i - 1];
            matrix[airCleaner[1]][i] = matrix[airCleaner[1]][i - 1];
        }

        matrix[airCleaner[0]][1] = 0;
        matrix[airCleaner[1]][1] = 0;
    }
}
