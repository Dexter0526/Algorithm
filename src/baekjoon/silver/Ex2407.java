package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 조합
public class Ex2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        BigInteger molecule = new BigInteger("1");
        BigInteger denominator = new BigInteger("1");

        if(m < n - m) m = n - m;

        for(int i = m + 1; i <= n; i++){
            molecule = molecule.multiply(new BigInteger(String.valueOf(i)));
        }

        for(int i = 1; i <= n - m; i++){
            denominator = denominator.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(molecule.divide(denominator));
    }
}
