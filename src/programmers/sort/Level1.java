package programmers.sort;

import java.util.Arrays;

//K번째 수
public class Level1 {
    public static void main(String[] args) {
//        array	commands	return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int[] temp = {};
        int i, j, k;
        answer = new int[commands.length];

        for(int m = 0; m < commands.length; m++) {
            i = commands[m][0];
            j = commands[m][1];
            k = commands[m][2];
            temp = new int[j-i+1];
            for(int n = 0; n < j-i+1; n++) {
                temp[n] = array[n+i-1];
            }
            Arrays.sort(temp);
            answer[m] = temp[k-1];
        }
        for(i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }
}
