package programmers.search;

import java.util.Arrays;

// 징검다리
public class Level4_1 {
    public static void main(String[] args) {

    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int start = 1;
        int end = distance;
        int mid = 0;

        Arrays.sort(rocks);

        while (start <= end){
            mid = (start + end) / 2;
            int prev = 1;
            int remove = 0;

            for(int rock : rocks){
                if(rock - prev < mid) {
                    remove++;
                }else{
                    prev = rock;
                }

                if(remove > n) break;
            }

            if(remove > n) end = mid - 1;
            else {
                start = mid + 1;
                answer = Math.max(answer, mid);
            }

        }

        return answer;
    }
}
