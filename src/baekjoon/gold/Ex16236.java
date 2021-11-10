package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기 상어
public class Ex16236 {
    public static int N;
    public static int[][] matrix;
    public static boolean[][] isVisit;
    public static int[] shark = new int[3];
    public static int eat = 0;
    public static int[] dx = {0, -1, 1, 0};
    public static int[] dy = {1, 0, 0, -1};
    public static int second = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[N][N];
        isVisit = new boolean[N][N];
        shark[2] = 2;

        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(matrix[i][j] == 9){
                    shark[0] = i;
                    shark[1] = j;
                }
            }
        }

        bfs(shark[0], shark[1]);
        System.out.println(second);
    }

    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        isVisit[x][y] = true;
        matrix[x][y] = 0;

        while (!queue.isEmpty()){
            int[] temp = queue.remove();

//            먹을 때
            if(matrix[temp[0]][temp[1]] != 0 && matrix[temp[0]][temp[1]] < shark[2]){
                eat++;
                if(shark[2] == eat) {
                    shark[2]++;
                    eat = 0;
                }
                second += temp[2];
                shark[0] = temp[0];
                shark[1] = temp[1];

                queue.clear();
                isVisit = new boolean[N][N];
                isVisit[shark[0]][shark[1]] = true;
                matrix[shark[0]][shark[1]] = 0;
                temp[2] = 0;

                System.out.println(temp[0] + " " + temp[1]);
                System.out.println("second ::: " + second);
            }

//            탐색
            for(int i = 0; i < 4; i++){
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];

                if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                    if(!isVisit[newX][newY] && matrix[newX][newY] <= shark[2]){
                        queue.add(new int[] {newX, newY, temp[2] + 1});
                        isVisit[newX][newY] = true;
                    }

                }
            }

//            탐색 후 먹을 때(고려)
        }

    }

}
