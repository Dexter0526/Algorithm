package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팩토리얼 0의 개수
public class Ex1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        while (number >= 5){
            count += number / 5;
            number /= 5;
        }

        System.out.println(count);

    }
}
