package kakao.twentytwo.blind;

import java.util.*;
import java.util.stream.Collectors;

// 주차 요금 계산
public class Level2_2 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer = solution(fees, records);

        for (int result : answer){
            System.out.println(result);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

//        fees 0: 기본시간, 1: 기본요금, 2: 단위시간, 3: 단위요금

        Map<String, String[]> recordsCalculation = new HashMap<>();

        for (String record : records){
            String[] spiltRecord = record.split(" ");
            if (recordsCalculation.containsKey(spiltRecord[1])){
                String[] temp = recordsCalculation.get(spiltRecord[1]);
                if (spiltRecord[2].equals("OUT")) {
                    String in = temp[0];
                    int inConvert = Integer.parseInt(in.split(":")[0]) * 60 + Integer.parseInt(in.split(":")[1]);
                    int outConvert = Integer.parseInt(spiltRecord[0].split(":")[0]) * 60 + Integer.parseInt(spiltRecord[0].split(":")[1]);

                    temp[1] = String.valueOf(Integer.parseInt(temp[1]) + (outConvert - inConvert));
                    temp[0] = null;
                } else {
                    temp[0] = spiltRecord[0];
                }

                recordsCalculation.put(spiltRecord[1], temp);
            } else {
                recordsCalculation.put(spiltRecord[1], new String[]{spiltRecord[0], "0"});
            }
        }

        List<String> keys = recordsCalculation.keySet().stream().sorted().collect(Collectors.toList());
        answer = new int[keys.size()];
        int index = 0;

        for (String key : keys){
            if (recordsCalculation.containsKey(key)){
                String[] temp = recordsCalculation.get(key);
                        
                int total = 0;
                if (temp[0] == null){
                    total = Integer.parseInt(temp[1]);
                } else{
                    total = Integer.parseInt(temp[1]) + (23 * 60 + 59 - (Integer.parseInt(temp[0].split(":")[0]) * 60 + Integer.parseInt(temp[0].split(":")[1])));
                }

                int a = fees[1];
                int b = ((total - fees[0]) % fees[2] == 0 ? (total - fees[0]) : (total - fees[0]) + fees[2]) / fees[2] * fees[3];
                if (b < 0) b = 0;
                answer[index] = a + b;
            }

            index++;
        }

        return answer;
    }
}
