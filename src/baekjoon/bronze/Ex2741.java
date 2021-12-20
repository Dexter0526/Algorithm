package baekjoon.bronze;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// N 찍기
public class Ex2741 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= n; i++){
            bufferedWriter.write(i + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
