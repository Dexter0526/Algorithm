package baekjoon.bronze;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 기찍 N
public class Ex2742 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = scanner.nextInt();

        for (int i = N; i > 0; i--){
            bufferedWriter.write(i + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
