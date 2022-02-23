package programmers.monthly.season02;

// 음양 더하기
public class Level1_1 {
    public static void main(String[] args) {

    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < signs.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
