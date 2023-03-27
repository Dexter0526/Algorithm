package kakao.twentytwo.intern;

import java.util.LinkedList;
import java.util.Queue;

// 두 큐 합 같게 만들기
public class Level2 {
    public static void main(String[] args) {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        int answer = solution(queue1, queue2);
        System.out.println(answer);
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        int count = 0;

        while (sum1 != sum2) {
            if (sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
            } else if (sum1 < sum2) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.add(q2.poll());
            }

            if (count > (queue1.length + queue2.length) * 2) {
                count = -1;
                break;
            }

            count++;
        }

        answer = count;

        return answer;
    }

}
