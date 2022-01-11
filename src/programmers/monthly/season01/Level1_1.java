package programmers.monthly.season01;

// 내적
public class Level1_1 {
    public static void main(String[] args) {

    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i = 0; i < a.length; i++){
            answer += a[i] * b[i];
        }

        return answer;
    }
}
