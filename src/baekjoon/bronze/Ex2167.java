package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 	2차원 배열의 합
public class Ex2167 {
    public static void main(String[] args) throws IOException {
        int[][] array;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        array = new int[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())];

        for(int i = 0; i < array.length; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for(int j = 0; j < array[i].length; j++){
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int n = Integer.parseInt(bufferedReader.readLine());

        for(int a = 0; a < n; a++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int answer = 0;
            for(int b = i - 1; b < x; b++){
                for(int c = j - 1; c < y; c++){
                    answer+= array[b][c];
                }
            }

            System.out.println(answer);
        }
    }

}
