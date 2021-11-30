package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 곱셈(분할 정복)
public class Ex1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long A = Long.parseLong(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());
        long C = Long.parseLong(stringTokenizer.nextToken());

        System.out.println(pow(A, B, C));
    }

    private static long pow(long number, long exponent, long mod){
        if(exponent == 1) return number % mod;

        long half = pow(number, exponent / 2, mod);
        if(exponent % 2 == 1) return (half * half % mod) * number % mod;
        else return half * half % mod;
    }
}
