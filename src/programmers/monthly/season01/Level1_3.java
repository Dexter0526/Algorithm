package programmers.monthly.season01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 두 개 뽑아서 더하기
public class Level1_3 {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> plus = new HashSet<>();

        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                plus.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[plus.size()];
        ArrayList<Integer> list = new ArrayList<>(plus);

        for(int i = 0; i < plus.size(); i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
