package programmers.monthly.season01;

// 3진법 뒤집기
public class Level1_2 {
    public static void main(String[] args) {
        solution(45);
    }

    public static int solution(int n) {
        int answer = 0;
        StringBuffer convert = new StringBuffer();

        while (n >= 3){
            convert.append(n % 3);
            n /= 3;
        }

        convert.append(n);

        System.out.println(convert);

        answer = Integer.parseInt(convert.toString(), 3);

        return answer;
    }
}
