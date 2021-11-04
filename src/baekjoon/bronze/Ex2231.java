package baekjoon.bronze;

import java.util.Scanner;

// 분해합
public class Ex2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;

        for(int i = 0; i < n; i++){
            int number = i;
            int sum = 0;
            while (number != 0){
                sum += number % 10;
                number /= 10;
            }

            if(i + sum == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
