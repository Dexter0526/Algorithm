package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 체스판 다시 칠하기
public class Ex1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        char[][] matrix = new char[n][m];
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            String line = bufferedReader.readLine();
            for(int k = 0; k < line.length(); k++){
                matrix[i][k] = line.charAt(k);
            }
        }

        bufferedReader.close();

        for(int i = 0; i <= n - 8; i++){
            for(int j = 0; j <= m - 8; j++){
                int count = 0;
                char color = matrix[i][j];
                for(int k = i; k < i + 8; k++){
                    for(int l = j; l < j + 8; l++){
                        if(matrix[k][l] != color) count++;

                        color = color == 'B' ? 'W' : 'B';
                    }
                    color = color == 'B' ? 'W' : 'B';
                }

                count = Math.min(count, 64 - count);

                min = Math.min(min, count);
            }
        }

        System.out.println(min);

    }
}
