package baekjoon.silver;

import java.util.Scanner;

// 2×n 타일링
public class Ex11726 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int first = 1;
//        int answer = 2;
//
//        for(int i = 3; i <= n; i++){
//            int temp = (first + answer) % 10007;
//            first = answer;
//            answer = temp;
//        }
//        System.out.println(answer);

        int[] numbers = new int[1001];
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 2;

        for(int i = 3; i <= n; i++){
            numbers[i] = (numbers[i - 1] + numbers[i - 2]) % 10007;
        }
        System.out.println(numbers[n]);
    }

}
