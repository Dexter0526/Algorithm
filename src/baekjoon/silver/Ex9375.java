package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 패션왕 신해빈
public class Ex9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T --> 0){
            int N = Integer.parseInt(bufferedReader.readLine());
            HashMap<String, Integer> costume = new HashMap<>();
            int combination = 1;
            while (N --> 0){
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                stringTokenizer.nextToken();
                String category = stringTokenizer.nextToken();

                costume.put(category, costume.getOrDefault(category, 0) + 1);
            }

            for(int category : costume.values()){
                combination *= (category + 1);
            }

            stringBuilder.append(combination - 1).append("\n");
        }

        System.out.println(stringBuilder);
    }

}
