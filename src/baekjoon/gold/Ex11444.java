package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수 6
public class Ex11444 {
//    시간초과
    public static void main(String[] args) throws IOException {
        final long MOD = 1_000_000_007;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bufferedReader.readLine());
        long first = 0;
        long second = 1;

        for(long i = 2; i <= n; i++){
            long temp = (first + second) % MOD;
            first = second % MOD;
            second = temp;
//            System.out.println(second);
        }

        System.out.println(second);

    }
}
