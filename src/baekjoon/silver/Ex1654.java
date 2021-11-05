package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 랜선 자르기
public class Ex1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int K = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        long min;
        long max;
        long mid;

        int[] lan = new int[K];
        for(int i = 0; i < K; i++){
            lan[i] = Integer.parseInt(bufferedReader.readLine());
        }

        bufferedReader.close();

        Arrays.sort(lan);

        min = 1;
        max = lan[lan.length - 1];

        while (min <= max){
            long count = 0;
            mid = (min + max) / 2;

            for(int i = 0; i < lan.length; i++){
                count += lan[i] / mid;
            }

            if(count < N) max = mid - 1;
            else min = mid + 1;
        }

        System.out.println(max);
    }
}
