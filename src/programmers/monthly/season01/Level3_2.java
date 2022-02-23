package programmers.monthly.season01;

// 스타 수열
public class Level3_2 {
    public static void main(String[] args) {
        int[] a = {0,3,3,0,7,2,0,2,2,0};

        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int answer = 0;
        int[] count = new int[a.length];
        for(int number : a) count[number]++;

        for(int i = 0; i < a.length; i++){
            if(count[i] == 0 || count[i] <= answer) continue;
            int length = 0;

            for(int j = 0; j < a.length - 1; j++){
                if ((a[j] != i && a[j + 1] != i) || a[j] == a[j + 1]) continue;
                length++;
                j++;
            }

            answer = Math.max(answer, length);

        }

        answer = answer * 2;

        return answer;
    }
}
