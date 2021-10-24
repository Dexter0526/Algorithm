package baekjoon.bronze;

import java.util.Scanner;

// 적어도 대부분의 배수
public class Ex1145 {
//    무식하게 숫자 처음부터 모든 탐색
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        int temp = 1;
        int count = 0;

        for(int i = 0; i < 5; i++){
            numbers[i] = scanner.nextInt();
        }

        while (true){
            count = 0;
            for(int i = 0; i < numbers.length; i++){
                if(temp % numbers[i] == 0) count++;
            }
            if(count >= 3) {
                break;
            }
            temp++;
        }

        System.out.println(temp);
    }

//    DFS로 해결!!

}
