package baekjoon.silver;

import java.util.Scanner;

// 최대공약수와 최소공배수
public class Ex2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int c = gcd(a, b);

        System.out.println(c);
        System.out.println(a * b / c);
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a % b);
    }
}
