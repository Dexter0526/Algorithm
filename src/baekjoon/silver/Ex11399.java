package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ATM
public class Ex11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(array);
        int total = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            total += array[i];
            answer += total;
        }

        System.out.println(answer);
    }
}
