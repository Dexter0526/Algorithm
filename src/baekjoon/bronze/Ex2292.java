package baekjoon.bronze;

import java.util.Scanner;

// 벌집
public class Ex2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int answer = 2;
        int first = 2;
        int second = 7;


        while (true){
            if(n >= first && n <= second) break;

            first = second + 1;
            second = second + 6 * answer;
            answer++;
        }

        System.out.println(n == 1 ? 1 : answer);
    }
}
