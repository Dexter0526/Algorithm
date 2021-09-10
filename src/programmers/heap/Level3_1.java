package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// 디스크 컨트롤러
public class Level3_1 {
    public static void main(String[] args) {
//        jobs	return
//[[0, 3], [1, 9], [2, 6]]	9
//        [[0, 10], [4, 10], [15, 2], [5, 11]], 15
        int[][] jobs = {{3, 6}, {3, 1}};
        int answer = solution(jobs);
        System.out.println("answer" + answer);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;   // 현재 시간

        PriorityQueue<int[]> priorityQueueSort_0_index = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> priorityQueueSort_1_index = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        priorityQueueSort_0_index.addAll(Arrays.stream(jobs).collect(Collectors.toList()));

        while (!priorityQueueSort_0_index.isEmpty()){
            if(time >= priorityQueueSort_0_index.peek()[0]){
                priorityQueueSort_1_index.add(priorityQueueSort_0_index.poll());
            }else if(!priorityQueueSort_1_index.isEmpty()){
                int[] temp = priorityQueueSort_1_index.poll();
                time += temp[1];
                answer += time - temp[0];
            }else{
                int[] temp = priorityQueueSort_0_index.poll();
                time = temp[0];
                priorityQueueSort_1_index.add(temp);
            }

        }

        while (!priorityQueueSort_1_index.isEmpty()){
            int[] temp = priorityQueueSort_1_index.poll();
            time += temp[1];
            answer += time - temp[0];
        }

        answer /= jobs.length;

        return answer;
    }
}
