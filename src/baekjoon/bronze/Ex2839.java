package baekjoon.bronze;

import java.util.Scanner;

// 설탕 배달
public class Ex2839 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();

        if(total == 4 || total == 7){
            System.out.println("-1");
        }else if(total % 5 == 1 || total % 5 == 3){
            System.out.println(total / 5 + 1);
        }else if(total % 5 == 2 || total % 5 == 4){
            System.out.println(total / 5 + 2);
        }else{
            System.out.println(total / 5);
        }
    }
}
