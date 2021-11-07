package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지번호붙이기
public class Ex2667 {
    public static int N;
    public static int[][] matrix;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] isVisit;
    public static int number;
    public static List<Integer> apartCount = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[N][N];
        isVisit = new boolean[N][N];
        number = 0;

        for(int i = 0 ; i < N; i++){
            String line = bufferedReader.readLine();
            for(int j = 0; j < line.length(); j++){
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(matrix[i][j] == 1 && !isVisit[i][j]){
                    number = 1;
                    bfs(i, j);
                    apartCount.add(number);
                }
            }
        }

        Collections.sort(apartCount);
        System.out.println(apartCount.size());
        for(int i = 0; i < apartCount.size(); i++){
            if(apartCount.get(i) != null) System.out.println(apartCount.get(i));
        }
    }

    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        isVisit[x][y] = true;

        while (!queue.isEmpty()){
            int[] temp = queue.remove();
            for(int i = 0; i < 4; i++){
                int newX = dx[i] + temp[0];
                int newY = dy[i] + temp[1];

                if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                    if(matrix[newX][newY] == 1 && !isVisit[newX][newY]){
                        queue.add(new int[]{newX, newY});
                        isVisit[newX][newY] = true;
                        number++;
                    }
                }
            }

        }
    }
}
