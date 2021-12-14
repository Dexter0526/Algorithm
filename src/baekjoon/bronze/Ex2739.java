package baekjoon.bronze;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 구구단
public class Ex2739 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = scanner.nextInt();

        for(int i = 1; i <= 9; i++){
            bufferedWriter.write(number + " * " + i + " = " + number * i + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
