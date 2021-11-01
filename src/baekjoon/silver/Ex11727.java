package baekjoon.silver;

import java.util.Scanner;

// 2×n 타일링 2
public class Ex11727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] numbers = new int[1001];
        numbers[1] = 1;
        numbers[2] = 3;

        for(int i = 3; i <= n; i++){
            numbers[i] = (numbers[i - 1] + 2 * numbers[i - 2]) % 10007;
        }
        System.out.println(numbers[n]);
    }
}
