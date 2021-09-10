package programmers.sort;
import java.util.*;
import java.util.stream.Collectors;

//가장 큰 수
public class Level2_1 {
    public static void main(String[] args) {
//        numbers	return
//      [6, 10, 2]	"6210"
//      [3, 30, 34, 5, 9]	"9534330"
    }

    public String solution(int[] numbers) {
        String answer = "";
        int[][] sorting = new int[numbers.length][2];
        int count = 0;

        for(int i = 0; i < numbers.length; i++){
            String temp = Integer.toString(numbers[i]).repeat(4);
            sorting[i][0] = Integer.parseInt(temp.substring(0, 4));
            sorting[i][1] = numbers[i];
            count += sorting[i][0];
        }

        if(count == 0) {
            return "0";
        }

        Arrays.sort(sorting, Comparator.comparingInt(o1 -> o1[0]));

        for(int i = sorting.length - 1; i >= 0; i--){
            answer += sorting[i][1];
        }
        return answer;
    }
}
