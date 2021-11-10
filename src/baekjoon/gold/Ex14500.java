package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 테트로미노
public class Ex14500 {
    public static int N, M;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] matrix;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        matrix = new int[N][M];
        boolean[][] isVisit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < M; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                dfs(i, j, 0, 0, isVisit);
                exception(i, j);
            }
        }

        System.out.println(answer);

    }

    private static void dfs(int x, int y, int depth, int sum, boolean[][] isVisit){
        if(depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < N && newY < M){
                if(!isVisit[newX][newY]){
                    isVisit[newX][newY] = true;
                    dfs(newX, newY, depth+1, sum + matrix[newX][newY], isVisit);
                    isVisit[newX][newY] = false;
                }
            }
        }
    }

    private static void exception(int x, int y){
        int sum = matrix[x][y];
//        System.out.println("sum ::: " + sum);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < N && newY < M){
                sum += matrix[newX][newY];
                list.add(matrix[newX][newY]);
            }
        }

//        System.out.println("sum ::: " + sum + " size ::: " + list.size());

        if(list != null && list.size() == 4) {
            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);
                answer = Math.max(answer, sum - temp);
            }
        }else answer = Math.max(answer, sum);

    }


}
