package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이항 계수1
public class Ex11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int k = Integer.parseInt(numbers[1]);

        System.out.println(factorial(n) / (factorial(k) * factorial(n-k)));

    }

    private static int factorial(int number){
        if(number == 1 || number == 0) return 1;

        return factorial(number - 1) * number;
    }
}
