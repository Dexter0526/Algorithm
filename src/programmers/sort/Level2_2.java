package programmers.sort;
import java.util.Arrays;

//H-Index
public class Level2_2 {
    public static void main(String[] args) {

    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i = 1; i <= citations.length; i++) {
            int min = Math.min(i, citations[citations.length - i]);
            if(min > answer) answer = min;
            else break;
        }
        return answer;
    }
}
