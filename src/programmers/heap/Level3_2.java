package programmers.heap;

import java.util.*;

//이중우선순위큐
public class Level3_2 {
    public static void main(String[] args) {
//        operations	return
//["I 16","D 1"]	[0,0]
//["I 7","I 5","I -5","D -1"]	[7,5]
//        ["I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"] [6,5]
        String[] operations = {"I 3", "D 1", "D -1", "I 5"};

        int[] answer = solution(operations);
        System.out.println(Arrays.toString(answer));

    }

    public static int[] solution(String[] operations) {
        int[] answer = {};

//        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
//        Deque<Integer> deque = new ArrayDeque<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for(int i = 0; i < operations.length; i++){
            String[] temp = operations[i].split(" ");
            if(temp[0].equals("I")){
                int el = Integer.parseInt(temp[1]);
                maxQueue.offer(el);
                minQueue.offer(el);
            }else if(!maxQueue.isEmpty() && temp[0].equals("D")){
                System.out.println("operations ::: " + Arrays.toString(temp));
//                최대값 삭제
                if(temp[1].equals("1")){
                    int max = maxQueue.poll();
                    minQueue.remove(max);
//                    최소값 삭제
                }else if(temp[1].equals("-1")){
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
            }
        }

        if(!maxQueue.isEmpty()){
            answer = new int[]{maxQueue.poll(), minQueue.poll()};
        }else{
            answer = new int[]{0,0};
        }

        return answer;
    }
}
