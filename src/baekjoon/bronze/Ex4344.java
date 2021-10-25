package baekjoon.bronze;

import java.util.Scanner;

// 평균은 넘겠지
public class Ex4344 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCase = scanner.nextInt();

        for(int i = 0; i < totalCase; i++){
            double count = 0;
            double total = 0;
            int n = scanner.nextInt();
            int[] score = new int[n];
            for(int j = 0; j < n; j++){
                score[j] = scanner.nextInt();
                total += score[j];
            }

            double average = total / n;

            for(int j = 0; j < n; j++){
                if(score[j] > average) count++;
            }

            System.out.printf("%.3f%%\n",(count/n) * 100);
        }
    }
}
