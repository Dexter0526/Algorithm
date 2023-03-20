package programmers.greedy;

import java.util.Arrays;

// 최소직사각형
public class Level1_2 {
    public static void main(String[] args) {
        int[][] sizes = new int[2][2];
        solution(sizes);
    }

    public static int solution(int[][] sizes) {
        int answer = 0;

        int[] maxSize = {0, 0};

        for (int[] size : sizes) {
            int max = Arrays.stream(size).max().getAsInt();
            int min = Arrays.stream(size).min().getAsInt();

            maxSize[0] = Math.max(maxSize[0], max);
            maxSize[1] = Math.max(maxSize[1], min);
        }

        answer = maxSize[0] * maxSize[1];
        return answer;
    }
}
