package programmers.stackNqueue;

import java.util.*;
import java.util.stream.Collectors;

//프린트
public class Level2_3 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer = solution(priorities, location);
        System.out.println(answer);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer[]> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++){
            Integer[] temp = new Integer[2];
            temp[0] = priorities[i];
            temp[1] = i;
            queue.add(temp);
        }

        List<Integer> priorityList = Arrays.stream(priorities).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        while (!queue.isEmpty()){
            Integer[] temp = queue.poll();
            if(temp[0] == priorityList.get(0)){
                answer++;
                if(temp[1] == location){
                    break;
                }
                priorityList.remove(0);
            }else{
                queue.add(temp);
            }
        }

        return answer;
    }
}
