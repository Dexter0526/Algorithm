package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 만들기
public class Ex2630 {
    public static int N;
    public static int[][] matrix;
    public static int[] answer = new int[2];

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

        divide(0, 0, N);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    private static void divide(int x, int y, int size){
//        if(check(x, y, size)) {
//            answer[matrix[x][y]]++;
//            return;
//        }
        boolean check = true;
        int temp = matrix[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(temp != matrix[i][j]) {
                    check = false;
                    break;
                }
            }
            if (!check) break;
        }

        if(check){
            answer[matrix[x][y]]++;
            return;
        }

        int resize = size / 2;
        divide(x, y, resize);
        divide(x, y + resize, resize);
        divide(x + resize, y, resize);
        divide(x + resize, y + resize, resize);
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
