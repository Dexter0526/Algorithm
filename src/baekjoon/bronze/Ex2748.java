package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수2
public class Ex2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        long first = 0;
        long second = 1;

        for(int i = 2; i <= n; i++){
            long temp = first + second;
            first = second;
            second = temp;
        }

        System.out.println(second);

//        long cache[] = new long[n + 1];
//        cache[0] = 0;
//        cache[1] = 1;
//
//        for(int i = 2; i <= n; i++){
//            cache[i] = cache[i - 2] + cache[i - 1];
//        }
//
//        System.out.println(cache[n]);
    }
}
