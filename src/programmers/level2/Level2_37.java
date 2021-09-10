package programmers.level2;

import java.util.*;

public class Level2_37 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        solution(genres, plays);
    }

    public static int[] solution(String[] genres, int[] plays) {
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

//        List<Map.Entry<String, Integer>> entries = totalCount.entrySet().stream()
////                .sorted(Collections.reverseOrder())
//                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//                .collect(Collectors.toList());

        List<String> keySet = new ArrayList<>(totalCount.keySet());

        // Value 기준으로 내림차순 정렬.
        keySet.sort((o1, o2) -> totalCount.get(o2) - totalCount.get(o1));

//        결과 생성
        for (String item : keySet){
            System.out.println("key:::" + item + ":::value:::" + totalCount.get(item));

            List<int[]> temp = sortMap.get(item);
            temp.sort(((o1, o2) -> o2[0] - o1[0]));

            result.add(temp.get(0)[1]);
            if(temp.size() > 1) result.add(temp.get(1)[1]);



        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();

        // 테스트 출력
//        for (String item : keySet){
//            System.out.println("key:::" + item + ":::value:::" + totalCount.get(item));
//            System.out.println("key:::" + item + ":::value:::" + sortMap.get(item).toString());
//
//            List<int[]> temp = sortMap.get(item);
//            for (int[] i : temp){
//                System.out.println(i[0]);
//                System.out.println(i[1]);
//            }
//        }

        return answer;
    }
}
