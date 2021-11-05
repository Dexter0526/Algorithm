package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 카드 2
public class Ex10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] cards = new int[20000001];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < N; i++){
            cards[Integer.parseInt(stringTokenizer.nextToken()) + 10000000]++;
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < M; i++){
            stringBuilder.append(cards[Integer.parseInt(stringTokenizer.nextToken()) + 10000000]).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
