package baekjoon.bronze;

import java.util.Scanner;

// 더하기 사이클
public class Ex1110 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int compare = (number % 10) * 10 + (number / 10 + number % 10) % 10;
        int answer = 1;

        while (number != compare){
            compare = (compare % 10) * 10 + (compare / 10 + compare % 10) % 10;
            answer++;
        }

        System.out.println(answer);

    }
}
