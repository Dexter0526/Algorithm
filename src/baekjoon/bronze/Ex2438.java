package baekjoon.bronze;

import java.util.Scanner;

// 별 찍기 - 1
public class Ex2438 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                stringBuilder.append("*");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}
