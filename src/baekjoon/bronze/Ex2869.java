package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 달팽이는 올라가고 싶다
public class Ex2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] read = bufferedReader.readLine().split(" ");

        int A = Integer.parseInt(read[0]);
        int B = Integer.parseInt(read[1]);
        int V = Integer.parseInt(read[2]);

        System.out.println((V-B-1) / (A-B) + 1);
    }
}
