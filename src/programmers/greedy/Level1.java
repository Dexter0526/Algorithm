package programmers.greedy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//체육복
public class Level1 {
    public static void main(String[] args) {
//        n	lost	reserve	return
//                5	[2, 4]	[1, 3, 5]	5
//        5	[2, 4]	[3]	4
//        3	[3]	[1]	2
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int temp = 0;
        List<Integer> lostArr = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveArr = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        for(int i = 0; i < reserveArr.size(); i++) {
            temp = reserveArr.get(i);
            for(int j = 0; j < lostArr.size(); j++) {
                if(temp == lostArr.get(j)) {
                    lostArr.remove(j);
                    reserveArr.remove(i);
                    i -= 1;
                    j -= 1;
                    break;
                }
            }
        }

        for(int i = 0; i < reserveArr.size(); i++) {
            temp = reserveArr.get(i);
            for(int j = 0; j < lostArr.size(); j++) {
                if((temp+1) == lostArr.get(j) || (temp-1) == lostArr.get(j)) {
                    lostArr.remove(j);
                    reserveArr.remove(i);
                    i -= 1;
                    j -= 1;
                    break;
                }
            }
        }
        answer = n - lostArr.size();
        return answer;
    }
}
