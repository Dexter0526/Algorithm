package baekjoon.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 꼬마 정민
public class Ex11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        long A = Long.parseLong(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());
        long C = Long.parseLong(stringTokenizer.nextToken());

        System.out.println(A+B+C);
    }
}
