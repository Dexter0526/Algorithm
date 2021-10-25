package baekjoon.bronze;

import java.util.Scanner;

// 달력
public class Ex1924 {
    public static void main(String[] args) {
//        2007.01.01 = 월요일
        Scanner scanner = new Scanner(System.in);
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int temp = 0;
        for(int i = 0; i < x - 1; i++){
            temp += days[i];
        }
        temp += y;

        System.out.println(day[temp % 7]);
    }
}
