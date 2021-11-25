package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 부분 수열
public class Ex11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] rDp = new int[N];
        int[] lDp = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(Arrays.toString(numbers));

        for(int i = 0; i < N; i++){
            lDp[i] = 1;
            for(int j = 0; j < i; j++){
                if(numbers[i] > numbers[j] && lDp[i] < lDp[j] + 1) lDp[i] = lDp[j] + 1;
            }
        }

        for(int i = N - 1; i >= 0; i--){
            rDp[i] = 1;
            for(int j = N - 1; j > i; j--){
                if(numbers[i] > numbers[j] && rDp[i] < rDp[j] + 1) rDp[i] = rDp[j] + 1;
            }
        }

        System.out.println(Arrays.toString(lDp));
        System.out.println(Arrays.toString(rDp));

        for(int i = 0; i < N; i++){
            answer = Math.max(answer, lDp[i] + rDp[i]);
        }

        System.out.println(answer - 1);
    }

}
