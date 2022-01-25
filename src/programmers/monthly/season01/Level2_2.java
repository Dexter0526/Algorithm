package programmers.monthly.season01;

// 이진 변환 반복하기
public class Level2_2 {
    public static void main(String[] args) {
        int[] answer = solution("110010101001");
        System.out.println(answer[0] + " ::: " + answer[1]);
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")){
            int zero = 0;
            for(int i = 0; i < s.length(); i++){
                if (s.charAt(i) == '0') {
                    zero++;
                }
            }

            s = Integer.toBinaryString(s.length() - zero);

            answer[0]++;
            answer[1] += zero;
        }

        return answer;
    }
}
