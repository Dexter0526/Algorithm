package baekjoon.bronze;

import java.util.Scanner;

// 별 찍기 - 2
public class Ex2439 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.close();

        for(int i = 1; i <= N; i++){
            StringBuffer stringBuffer = new StringBuffer();

            for(int j = 1; j <= N - i; j++){
                stringBuffer.append(" ");
            }

            for(int k = 1; k <= i; k++){
                stringBuffer.append("*");
            }

            System.out.println(stringBuffer.toString());
        }
    }
}
