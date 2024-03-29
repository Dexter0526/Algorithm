package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 구하기
public class Ex1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for(int i = M; i <= N; i++) {
            if(!prime[i]) stringBuilder.append(i).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
