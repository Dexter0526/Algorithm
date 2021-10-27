package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분수 찾기
public class Ex1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bufferedReader.readLine());

        int cross = 1;
        int count = 0;

        while (true) {
            if (target <= cross + count) {
                if (cross % 2 == 0) {
                    System.out.print((target - count) + "/" + (cross - (target - count - 1)));
                    break;
                }
                else {
                    System.out.print((cross - (target - count - 1)) + "/" + (target - count));
                    break;
                }
            }
            count += cross;
            cross++;
        }
    }
}
