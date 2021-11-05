package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 좌표 정렬하기
public class Ex11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[n][2];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            matrix[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            matrix[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        bufferedReader.close();

        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });

        for(int i = 0; i < matrix.length; i++){
            stringBuilder.append(matrix[i][0]).append(" ");
            stringBuilder.append(matrix[i][1]).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
