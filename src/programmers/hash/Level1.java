package programmers.hash;

import java.util.Arrays;

// 완주하지 못한 선수
public class Level1 {

    public static void main(String[] args) {
//        answer = 	"leo";
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};


    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int index;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(index = 0; index < completion.length; index++) {
            if(!participant[index].equals(completion[index])) {
                return participant[index];
            }
        }

        return participant[index];
    }
}
