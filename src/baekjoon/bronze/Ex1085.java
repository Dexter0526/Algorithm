package baekjoon.bronze;

import java.util.Scanner;

// 직사각형에서 탈출
public class Ex1085 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        int answer = Math.min(x, Math.min(w - x, Math.min(y, h - y)));

        System.out.println(answer);
    }
}
