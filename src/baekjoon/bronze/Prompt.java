package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

//	명령 프롬프트
public class Prompt {
    public static void main(String[] args) {
        char[] answer;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];

        for(int i = 0; i < n; i++){
            str[i] = scanner.next();
        }

        answer = str[0].toCharArray();

        for(int i = 1; i < n; i++){
            for(int j = 0; j < answer.length; j++){
                if(answer[j] == '?') continue;
                if(answer[j] != str[i].charAt(j)) answer[j] = '?';
            }
        }

        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i]);
        }
    }
}
