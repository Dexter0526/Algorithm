package programmers.dev;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//로또의 최고 순위와 최저 순위
public class Level1 {
    public static void main(String[] args) {
//lottos	win_nums	result
//[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
//[0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
//[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]

        int[] lottos = {2, 3, 4, 5, 8, 9};
        int[] winQ_nums = {31, 10, 45, 1, 6, 19};
        int[] answer = solution(lottos, winQ_nums);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zero = 0;
        Set<Integer> win = new HashSet<>();

        for(int i = 0; i < win_nums.length; i++){
            win.add(win_nums[i]);
        }

        for(int i = 0; i < lottos.length; i++){
            if(win.remove(lottos[i])){
                count++;
            }else if(lottos[i] == 0) zero++;

        }
//        System.out.println(count);
//        System.out.println(zero);
        answer[0] = (7 - count - zero) > 5 ? 6 : (7 - count - zero);
        answer[1] = (7 - count) > 5 ? 6 : (7 - count);


        return answer;
    }
}
