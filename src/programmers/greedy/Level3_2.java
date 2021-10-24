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

        Arrays.sort(routes, (int[] c1, int[] c2) -> c1[0] - c2[0]);

        for(int[] temp : routes){
            System.out.println(Arrays.toString(temp));
        }

        int outNumber = routes[0][1];
        for(int i = 0; i < routes.length; i++){
            if(outNumber <= routes[i][0]){
                outNumber = routes[i][1];
            }else{
                answer++;
            }
        }

        return answer;
    }
}
