package programmers.exhausitive;

//카펫
public class Level2_1 {
    public static void main(String[] args) {
//        brown	yellow	return
//                10	2	[4, 3]
//        8	1	[3, 3]
//        24	24	[8, 6]
    }

    public int[] solution(int brown, int red) {
        int[] answer = {};
        answer = new int[2];
        int b = 2+brown/2;
        int c = brown + red;
        // answer[0] : x;
        // answer[1] : y;
        // 2x + 2y = brown + 4
        // x * y = brown + red
        // a = 1;

        answer[0] = (int) (b + Math.sqrt((Math.pow(b, 2) - 4*c)))/2;
        answer[1] = c / answer[0];
        return answer;
    }
}
