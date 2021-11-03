package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 찾기
public class Ex1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int count = 0;

        while (stringTokenizer.hasMoreTokens()){
            boolean isPrime = true;

            int number = Integer.parseInt(stringTokenizer.nextToken());

            if(number == 1) continue;

            for(int i = 2; i <= Math.sqrt(number); i++){
                if(number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.println(isPrime);

            if(isPrime) count++;
        }

        System.out.println(count);
    }
}
