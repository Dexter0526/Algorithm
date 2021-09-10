package programmers.exhausitive;
import java.util.Arrays;

//모의 고사
public class Level1 {
    public static void main(String[] args) {
//        answers	return
//[1,2,3,4,5]	[1]
//[1,3,2,4,2]	[1,2,3]
    }

    public int[] solution(int[] answers) {
        int[] answer = {};
        int length = answers.length;
        int[] count = new int[3];
        int[] arr = new int[3];

        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i = 0; i < length; i++) {
            if(answers[i] == num1[i % 5]) {
                count[0]++;
            }
            if(answers[i] == num2[i % 8]) {
                count[1]++;
            }
            if(answers[i] == num3[i % 10]) {
                count[2]++;
            }
        }
        arr = Arrays.copyOf(count, 3);
        Arrays.sort(count);
        length = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[count.length-1] == arr[i]) {
                length++;
            }
        }
        answer = new int[length];
        int index = 0;
        for(int i = 0; i < length; i++) {
            for(int j = index; j < arr.length; j++) {
                if(count[count.length-1] == arr[j]) {
                    answer[i] = j+1;
                    index = j+1;
                    break;
                }
            }
        }
        return answer;
    }
}
