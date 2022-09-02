package kakao.twentytwo.blind;

// k진수에서 소수 개수 구하기
public class Level2_1 {
    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
    }

    public static int solution(int n, int k) {
        int answer = 0;

        String convert = Integer.toString(n, k);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < convert.length(); i++){
            if (convert.charAt(i) == '0' && stringBuilder.length() != 0){
                if (isPrime(Long.parseLong(stringBuilder.toString())))
                    answer++;

                stringBuilder = new StringBuilder();
            }else {
                stringBuilder.append(convert.charAt(i));
            }
        }

        if (stringBuilder.length() != 0 && isPrime(Long.parseLong(stringBuilder.toString()))) {
            answer++;
        }

        return answer;
    }

    private static boolean isPrime(Long number){
        System.out.println(number);
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0 || number < 2) return false;

        for (int i = 3; i <= (int) Math.sqrt(number); i++){
            if (number % i == 0) return false;
        }

        return true;
    }
}
