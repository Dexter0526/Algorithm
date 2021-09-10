package programmers;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = {};
        int count = 0;
        List<String> convert = new LinkedList<>();

        Map<String, String> map = new HashMap();
        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");

            if(temp.length == 3
                    && (!map.containsKey(temp[1])
                    || !map.get(temp[1]).equals(temp[2]))) map.put(temp[1], temp[2]);

            if(temp[0].equals("Enter") || temp[0].equals("Leave")){
                String enter = "";
                if(temp[0].equals("Enter")){
                    enter = "들어왔습니다.";
                }else if(temp[0].equals("Leave")){
                    enter = "나갔습니다.";
                }
                convert.add(temp[1] + " 님이 " + enter);
                count++;
            };
        }

        answer = new String[count];

        for(int i = 0; i < convert.size(); i++){
            String[] temp = convert.get(i).split(" ");
            answer[i] = map.get(temp[0]) + temp[1] + " " + temp[2];
        }
    }
}
