package programmers.stackNqueue;


import java.util.*;
import java.util.stream.Collectors;

// 다리를 지나는 트럭
public class Level2_4 {
    public static void main(String[] args) {
//        bridge_length	weight	truck_weights	return
//                2	10	[7,4,5,6]	8
//        100	100	[10]	101
//        100	100	[10,10,10,10,10,10,10,10,10,10]	110

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int answer = solution(bridge_length, weight, truck_weights);
        System.out.println(answer);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer[]> bridge = new ArrayDeque<>();

        queue.addAll(Arrays.stream(truck_weights).boxed().collect(Collectors.toList()));
        int total_length = 0;   // 다리에 들어간 트럭 총 무게
        int time = 0;   // 현재 시간

        while (!queue.isEmpty()){
            Integer[] result = new Integer[2];
            if (queue.peek() + total_length <= weight){
                int temp = queue.poll();
                total_length += temp;
                time++;
                bridge.add(new Integer[]{temp, time + bridge_length});

                if(time >= bridge.peek()[1]){
                    result = bridge.poll();
                    total_length -= result[0];
                    answer = result[1];
                }

            }else{
                result = bridge.poll();
                time = result[1] - 1;
                total_length -= result[0];
                answer = result[1];
            }
        }

        if(!bridge.isEmpty()) answer = bridge.pollLast()[1];

        return answer;
    }
}
