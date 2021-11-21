package programmers.search;

// 입국심사
public class Level3_1 {
    public static void main(String[] args) {

    }

    public long solution(int n, int[] times) {
        long answer = 0;

        long start = 0;
        long end = (long) times[times.length - 1] * n;

        while(start <= end){
            long count = 0;
            long mid = (start + end) / 2;

            for(int time : times){
                count += mid / time;
            }

            if(count >= n){
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return answer;
    }
}
