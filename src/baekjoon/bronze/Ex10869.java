package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

// 사칙연산
public class Ex10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedReader.close();

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(a + b + "\n");
        bufferedWriter.write(a - b + "\n");
        bufferedWriter.write(a * b + "\n");
        bufferedWriter.write(a / b + "\n");
        bufferedWriter.write(a % b + "\n");

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
