package kakao.eighteen.blind;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// [1차] 추석 트래픽
// https://wellbell.tistory.com/98
public class Traffic {
    public static void main(String[] args) {

    }

    public static int solution(String[] lines) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        int answer = 0;

        int[] count = new int[lines.length];
        
        for(int i = 0; i < lines.length; i++){
            String[] start = lines[i].split(" ");
            Date startDate = simpleDateFormat.parse(start[1]);
            long startTime = startDate.getTime();

            for(int j = i; j < lines.length; j++){
                String[] end = lines[j].split(" ");
                Date endDate = simpleDateFormat.parse(end[1]);
                double sec = Double.parseDouble(end[2].replace("s", ""));
                long endTime = (long) (endDate.getTime() - sec * 1000 + 1);

                if (startTime + 1000 > endTime) {
                    count[i]++;
                    answer = Math.max(answer, count[i]);
                }

            }
        }

        return answer;
    }
}
