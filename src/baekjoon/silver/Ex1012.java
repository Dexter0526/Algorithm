package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
public class Ex1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < T; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());
            int[][] matrix = new int[M][N];
            boolean[][] isVisit = new boolean[M][N];
            int count = 0;

            for(int j = 0; j < K; j++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                matrix[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())] = 1;
            }

            for(int j = 0; j < M; j++){
                for(int k = 0; k < N; k++){
                    if(matrix[j][k] == 1 && !isVisit[j][k]){
                        count++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{j, k});
                        isVisit[j][k] = true;


                        while (!queue.isEmpty()){
                            int[] temp = queue.remove();
                            for(int l = 0; l < 4; l++){
                                int newX = dx[l] + temp[0];
                                int newY = dy[l] + temp[1];

                                if(newX >= 0 && newY >= 0 && newX < M && newY < N){
                                    if(matrix[newX][newY] == 1 && !isVisit[newX][newY]){
                                        queue.add(new int[]{newX, newY});
                                        isVisit[newX][newY] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            stringBuilder.append(count).append("\n");

        }

        System.out.println(stringBuilder);
    }
}
