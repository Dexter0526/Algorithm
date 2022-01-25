package programmers.monthly.season01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 삼각 달팽이
public class Level2_1 {
    public static void main(String[] args) {

    }

    public static int[] solution(int n) {
        int[] answer = {};
        List<Integer> list = new LinkedList<>();
        int[][] snail = new int[n][n];

        int x = -1;
        int y = 0;
        int number = 1;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else{
                    x--;
                    y--;
                }
                snail[x][y] = number++;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(snail[i][j] == 0) break;

                list.add(snail[i][j]);
            }
        }

        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}
