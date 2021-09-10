package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Level2_35 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 9};
        int k = 7;
        int answer = solution(scoville, k);

        System.out.println("answer:::" + answer);
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
//        List<Integer> temp = Arrays.stream(scoville).boxed().collect(Collectors.toList());
////        Collections.sort(temp);
//
//        while (Collections.min(temp) < K){
//            if(temp.size() < 2){
//                answer = -1;
//                break;
//            }
//            System.out.println(temp.toString());
//            Integer heap = temp.get(0) + temp.get(1) * 2;
//            System.out.println("heap:::" + heap);
//            temp.remove(0);
//            temp.remove(0);
//            temp.add(heap);
//            Collections.sort(temp);
//            answer++;
//        }
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
