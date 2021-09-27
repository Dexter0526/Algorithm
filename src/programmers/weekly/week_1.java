package programmers.weekly;

// 1주차 부족한 금액 계산하기
public class week_1 {
    public static void main(String[] args) {
        long answer = solution(3, 20, 4);
        System.out.println(answer);
    }

    public static long solution(int price, int money, int count) {
        long answer = 0;
        long temp = 0;

        for(int i = 0; i < count; i++){
            temp += price*(i+1);
        }

        if(temp > money){
            answer = temp - money;
        }

        return answer;
    }
}
