package kakao.twentytwo.intern;

import java.util.HashMap;
import java.util.Map;

// 성격 유형 검사하기
public class Level1 {
    public static void main(String[] args) {

    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        String[] indicators = {"RT", "CF", "JM", "AN"};

        Map<String, Integer> indicatorsScore = new HashMap<>();

        for (String personality : indicators) {
            indicatorsScore.put(String.valueOf(personality.charAt(0)), 0);
            indicatorsScore.put(String.valueOf(personality.charAt(1)), 0);
        }

        for (int i = 0; i < choices.length; i++) {
            if (choices[i] > 4) {
                int score = indicatorsScore.get(String.valueOf(survey[i].charAt(1)));
                indicatorsScore.put(String.valueOf(survey[i].charAt(1)), score + (choices[i] - 4));
            } else if (choices[i] < 4) {
                int score = indicatorsScore.get(String.valueOf(survey[i].charAt(0)));
                indicatorsScore.put(String.valueOf(survey[i].charAt(0)), score + (4 - choices[i]));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String personality : indicators) {
            int a = indicatorsScore.get(String.valueOf(personality.charAt(0)));
            int b = indicatorsScore.get(String.valueOf(personality.charAt(1)));
            if (a >= b) {
                stringBuilder.append(personality.charAt(0));
            } else {
                stringBuilder.append(personality.charAt(1));
            }
        }

        answer = stringBuilder.toString();

        return answer;
    }
}
