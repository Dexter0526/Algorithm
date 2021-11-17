package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카잉 달력
public class Ex6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T --> 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            int lcm = M * N / gcd(M, N);
            int answer = -1;
            int index = 0;
            while (index * M < lcm){
                if((index * M + x - y) % N == 0) {
                    answer = index * M + x;
                    break;
                }
                index++;
            }

            stringBuilder.append(answer).append("\n");
        }

        System.out.println(stringBuilder);

    }

    private static int gcd(int number1, int number2){
        if(number2 == 0) return number1;
        return gcd(number2, number1 % number2);
    }
}
