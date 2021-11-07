package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 0
public class Ex11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int[] coin = new int[N];
        int maxCoin = 0;
        int index = 0;
        int count = 0;

        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(bufferedReader.readLine());
            if(coin[i] <= K){
                maxCoin = Math.max(maxCoin, coin[i]);
                index = i;
            }
        }

        while (K != 0){
            count += K / coin[index];
            K = K % coin[index];
            index--;
        }

        System.out.println(count);
    }
}
