package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class Ex2178 {
    public static int[][] matrix;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int N;
    public static int M;
    public static int[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        matrix = new int[N][M];
        isVisit = new int[N][M];

        for(int i = 0; i < N; i++){
            String temp = bufferedReader.readLine();
            for(int j = 0; j < temp.length(); j++){
                matrix[i][j] = temp.charAt(j) - '0';
            }
        }
        bfs(matrix);
        System.out.println(isVisit[N - 1][M - 1]);

    }

    private static void bfs(int[][] matrix){
        Queue<Coordinate> queue = new LinkedList<>();
        Coordinate start = new Coordinate(0, 0);
        queue.add(start);
        isVisit[0][0] = 1;

        while (!queue.isEmpty()){
            Coordinate coordinate = queue.remove();
            if(coordinate.getX() == N - 1 && coordinate.getY() == M - 1) break;

            for(int i = 0; i < 4; i++){
                int x = dx[i] + coordinate.getX();
                int y = dy[i] + coordinate.getY();

                if(x >= 0 && y >= 0 && x < N && y < M){
                    if(matrix[x][y] == 1 && isVisit[x][y] == 0){
                        Coordinate next = new Coordinate(x, y);
                        queue.add(next);
                        isVisit[x][y] = isVisit[coordinate.getX()][coordinate.getY()] + 1;
                    }
                }

            }
        }

    }

    public static class Coordinate{
        private int x;
        private int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
