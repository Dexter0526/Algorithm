package baekjoon.bronze;

import java.util.Scanner;

// 평균
public class Ex1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];
        double answer = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++){
            if(max < numbers[i]) max = numbers[i];
            answer += numbers[i];
        }

        answer = (answer * 100) / max / n;

        System.out.println(answer);
    }
}
