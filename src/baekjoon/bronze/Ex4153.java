package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 직각삼각형
public class Ex4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] triangle = new int[3];
            triangle[0] = Integer.parseInt(stringTokenizer.nextToken());
            triangle[1] = Integer.parseInt(stringTokenizer.nextToken());
            triangle[2] = Integer.parseInt(stringTokenizer.nextToken());

            if(triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) break;

            Arrays.sort(triangle);

            if(Math.pow(triangle[0], 2) + Math.pow(triangle[1], 2) == Math.pow(triangle[2],2)){
                stringBuilder.append("right").append("\n");
            }else{
                stringBuilder.append("wrong").append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}
