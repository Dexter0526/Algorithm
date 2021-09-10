package programmers.heap;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// 더 맵게
public class Level2 {
    public static void main(String[] args) {
//[1, 2, 3, 9, 10, 12]	7	2

    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        while (priorityQueue.peek() < K){
            if(priorityQueue.size() < 2) {
                answer = -1;
                break;
            }
            Integer first_min = priorityQueue.poll();
            Integer second_min = priorityQueue.poll();
            Integer mix = first_min + second_min * 2;
            priorityQueue.add(mix);

            answer++;
        }
        return answer;
    }
}
