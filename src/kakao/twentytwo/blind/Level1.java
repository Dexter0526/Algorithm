package kakao.twentytwo.blind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Level1 {
    public static void main(String[] args) {

    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> id_list_count = new HashMap<>();
        Map<String, Integer> id_list_index = new HashMap<>();

        for (int i = 0; i < id_list.length; i++){
            id_list_count.put(id_list[i], new HashSet<>());
            id_list_index.put(id_list[i], i);
        }

        for (int i = 0; i < report.length; i++){
            Set<String> userId = id_list_count.get(report[i].split(" ")[1]);
            userId.add(report[i].split(" ")[0]);
            id_list_count.put(report[i].split(" ")[1], userId);
        }

        for (int i = 0; i < id_list.length; i++){
            String user = id_list[i];
            if(id_list_count.get(user).size() >= k) {
                for(String userId : id_list_count.get(user)){
                    answer[id_list_index.get(userId)]++;
                }
            }
        }

        return answer;
    }


}
