package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 정렬하기 3
public class Ex10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] number = new int[n];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(number);

        for(int i = 0; i < n; i++){
            stringBuilder.append(number[i]).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
