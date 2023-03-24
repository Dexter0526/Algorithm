package kakao.twentythree.blind;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// 개인정보 수집 유효기간
public class Level1 {
    public static void main(String[] args) {
        String today = "2024.06.08";
        String[] terms = {"A 18"};
        String[] privacies = {"2022.06.08 A"};

        int[] answer = solution(today, terms, privacies);
        for (int i : answer){
            System.out.println(i);
        }

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        int[] todayDate = new int[3];
        Queue<Integer> queue = new LinkedList<>();
        todayDate[0] = Integer.parseInt(today.split("\\.")[0]);
        todayDate[1] = Integer.parseInt(today.split("\\.")[1]);
        todayDate[2] = Integer.parseInt(today.split("\\.")[2]);

        HashMap<String, Integer> termsMap = new HashMap<>();

        for (String term : terms) {
            termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String date = privacies[i].split(" ")[0];
            String term = privacies[i].split(" ")[1];
            int[] dateParse = new int[3];
            dateParse[0] = Integer.parseInt(date.split("\\.")[0]);
            dateParse[1] = Integer.parseInt(date.split("\\.")[1]);
            dateParse[2] = Integer.parseInt(date.split("\\.")[2]);

            int duration = termsMap.get(term);

            dateParse[1] += duration;

            if (dateParse[1] % 12 == 0) {
                dateParse[0] += (dateParse[1] / 12) - 1;
                dateParse[1] = 12;
            } else {
                int temp = dateParse[1] % 12;
                dateParse[0] += dateParse[1] / 12;
                dateParse[1] = temp;
            }

            System.out.println(dateParse[0] + "." + dateParse[1] + "." + dateParse[2]);
            if (todayDate[0] < dateParse[0]) queue.add(i + 1);
            else if (todayDate[0] == dateParse[0] && todayDate[1] < dateParse[1]) queue.add(i + 1);
            else if (todayDate[0] == dateParse[0] && todayDate[1] == dateParse[1] && todayDate[2] <= dateParse[2])
                queue.add(i + 1);
        }
        answer = new int[queue.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}
