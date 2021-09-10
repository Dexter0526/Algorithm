package programmers.level2;

import java.util.*;

public class Level2_36 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> linkedList = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.add(days);
        }

        
        int temp = queue.poll();
        linkedList.add(1);

        while (!queue.isEmpty()){
            int poll = queue.poll();
            if(poll <= temp){
                linkedList.set(linkedList.size()-1, linkedList.get(linkedList.size() - 1) + 1);
            }else{
                linkedList.add(1);
                temp = poll;
            }

        }
        answer = linkedList.stream().mapToInt(i->i).toArray();


        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {99, 99, 99};
        int[] speeds = {1,1,1};
        int[] answer = solution(progresses, speeds);
        System.out.println(Arrays.toString(answer));
    }
}
