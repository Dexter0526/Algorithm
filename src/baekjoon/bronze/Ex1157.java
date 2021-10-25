package baekjoon.bronze;

import java.util.Scanner;

// 단어 공부
public class Ex1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int[] frequency = new int[26];

        word = word.toUpperCase();

        for(int i = 0; i < word.length(); i++){
            int temp = word.charAt(i);
            frequency[temp-65]++;
        }

        int max = -1;
        int index = 63;
        for(int i = 0; i < frequency.length; i++){
            if(max < frequency[i]){
                max = frequency[i];
                index = i + 65;
            }else if(max == frequency[i]){
                index = 63;
            }
        }
        System.out.println((char) index);
    }
}
