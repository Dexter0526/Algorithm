package programmers.stackNqueue;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 기능개발
public class Level2_1 {
    public static void main(String[] args) {
//        answer = {2, 1};
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
    }

    public int[] solution(int[] progresses, int[] speeds) {
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
}
