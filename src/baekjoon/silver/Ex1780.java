package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 종이의 개수
public class Ex1780 {
    public static int[][] matrix;
    public static int[] answer = new int[3];
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int j = 0;
            while (stringTokenizer.hasMoreTokens()){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                j++;
            }
        }

        divide(0, 0, N);

        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    private static void divide(int x, int y, int size){
        if(check(x, y, size)){
            int count = matrix[x][y];
            switch (count){
                case -1:
                    answer[0]++;
                    break;
                case 0:
                    answer[1]++;
                    break;
                case 1:
                    answer[2]++;
                    break;
                default:
                    break;
            }
            return;
        }

        int section = size / 3;

        divide(x, y, section);
        divide(x, y + section, section);
        divide(x, y + section * 2, section);

        divide(x + section, y, section);
        divide(x + section * 2, y, section);

        divide(x + section, y + section, section);
        divide(x + section, y + section * 2, section);
        divide(x + section * 2, y + section, section);
        divide(x + section * 2, y + section * 2, section);

    }

    private static boolean check(int x, int y, int size){
        int temp = matrix[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(temp != matrix[i][j]) return false;
            }
        }
        return true;
    }
}
