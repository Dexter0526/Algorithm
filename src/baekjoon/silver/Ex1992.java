package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쿼드트리
public class Ex1992 {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[N][N];
        for(int i = 0; i < N; i++){
            String line = bufferedReader.readLine();
            for(int j = 0; j < line.length(); j++){
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        divide(0, 0, N);

        System.out.println(stringBuilder);
    }

    private static void divide(int x, int y, int size){
        if(check(x, y, size)) {
            stringBuilder.append(matrix[x][y]);
            return;
        }

        stringBuilder.append("(");
        size /= 2;
        divide(x, y, size);
        divide(x, y + size, size);
        divide(x + size, y, size);
        divide(x + size, y + size, size);
        stringBuilder.append(")");

    }

    private static boolean check(int x, int y, int size){
        int temp = matrix[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(matrix[i][j] != temp) return false;
            }
        }
        return true;
    }
}
