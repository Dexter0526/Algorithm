package programmers.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 단속 카메라
public class Level3_2 {
    public static void main(String[] args) {

        int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};

        solution(routes);
    }

    public static int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;

        Arrays.sort(routes, (int[] o1, int[] o2) -> o1[1] - o2[1]);

        for(int i = 0; i < routes.length; i++){
            if(routes[i][0] > min ){
                min = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
