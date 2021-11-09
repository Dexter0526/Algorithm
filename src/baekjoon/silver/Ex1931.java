package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 회의실 배정
public class Ex1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] rooms = new int[N][2];
        int count = 0;
        int finish = 0;

        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            rooms[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            rooms[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        finish = rooms[0][1];
        count = 1;
        for(int i = 1; i < N; i++){
            if(rooms[i][0] >= finish){
                count++;
                finish = rooms[i][1];
            }
        }

        System.out.println(count);

    }
}
