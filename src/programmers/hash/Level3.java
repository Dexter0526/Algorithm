package programmers.hash;
import java.util.*;

//베스트앨범
public class Level3 {
    public static void main(String[] args) {
//        answer = {4, 1, 3, 0};
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> totalCount = new HashMap<>();

        Map<String, List> sortMap = new HashMap<>();

        List<Integer> result = new LinkedList<>();

        for(int i = 0; i < genres.length; i++){
            List<int[]> temp = new LinkedList();
            int play = plays[i];
            int[] playArray = {play, i};
            String genre = genres[i];

            if(totalCount.containsKey(genre)){
                temp = sortMap.get(genre);
                play = totalCount.get(genre) + plays[i];
            }

            temp.add(playArray);
            totalCount.put(genre, play);
            sortMap.put(genre, temp);
        }

        List<String> keySet = new ArrayList<>(totalCount.keySet());

        // Value 기준으로 내림차순 정렬.
        keySet.sort((o1, o2) -> totalCount.get(o2) - totalCount.get(o1));

//        결과 생성
        for (String item : keySet){
            // System.out.println("key:::" + item + ":::value:::" + totalCount.get(item));

            List<int[]> temp = sortMap.get(item);
            temp.sort(((o1, o2) -> o2[0] - o1[0]));

            result.add(temp.get(0)[1]);
            if(temp.size() > 1) result.add(temp.get(1)[1]);


            // for(int i = 0; i < 2; i++){
            //     result.add(temp.get(i)[1]);
            // }

        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
