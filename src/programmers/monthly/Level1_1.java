package programmers.monthly;

// 없는 숫자 더하기
public class Level1_1 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        boolean[] check = new boolean[10];

        for(int i = 0; i < numbers.length; i++){
            check[numbers[i]] = true;
        }

        for(int i = 0; i < check.length; i++){
            if(!check[i]) answer += i;
        }

        return answer;
    }
}
