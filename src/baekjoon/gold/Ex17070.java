package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 파이프 옮기기 1
public class Ex17070 {
    public static int N;
    public static int[][] matrix;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        if(matrix[N - 1][N - 1] == 1) {
            System.out.println(0);
            return;
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs(){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{0, 1, 0});

        while (!queue.isEmpty()){
            int[] now = queue.remove();

            if(now[0] == N - 1 && now[1] == N - 1) {
                answer++;
                continue;
            }

            switch (now[2]){
//                가로
                case 0:
                    if(now[1] + 1 < N && matrix[now[0]][now[1] + 1] != 1)
                        queue.add(new int[]{now[0], now[1] + 1, 0});
                    break;
//                세로
                case 1:
                    if(now[0] + 1 < N && matrix[now[0] + 1][now[1]] != 1)
                        queue.add(new int[]{now[0] + 1, now[1], 1});
                    break;
//                가로, 세로
                case 2:
                    if(now[1] + 1 < N && matrix[now[0]][now[1] + 1] != 1)
                        queue.add(new int[]{now[0], now[1] + 1, 0});
                    if(now[0] + 1 < N && matrix[now[0] + 1][now[1]] != 1)
                        queue.add(new int[]{now[0] + 1, now[1], 1});
                    break;
                default:
                    break;
            }
//            default 대각
            if(now[0] + 1 < N && now[1] + 1 < N
                    && matrix[now[0] + 1][now[1] + 1] != 1
                    && matrix[now[0]][now[1] + 1] != 1
                    && matrix[now[0] + 1][now[1]] != 1)
                queue.add(new int[]{now[0] + 1, now[1] + 1, 2});

        }
    }
}
