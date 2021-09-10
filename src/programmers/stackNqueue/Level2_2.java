package programmers.stackNqueue;

//주식 가격
public class Level2_2 {
    public static void main(String[] args) {
//        answer = {4, 3, 1, 1, 0};
        int[] prices = {1, 2, 3, 2, 3};

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            for(int j = i; j < prices.length; j++) {
                if(prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }else if(j == prices.length-1) {
                    answer[i] = j-i;
                }
            }
        }
        return answer;
    }
}
