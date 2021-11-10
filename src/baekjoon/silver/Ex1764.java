package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 듣보잡
public class Ex1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<String> names = new HashSet<>();
        LinkedList<String> answer = new LinkedList<>();

        for(int i = 0; i < N; i++){
            names.add(bufferedReader.readLine());
        }


        for(int i = 0; i < M; i++){
            String name = bufferedReader.readLine();

            if(names.contains(name)){
                answer.add(name);
            }
        }

        Collections.sort(answer);

        stringBuilder.append(answer.size()).append("\n");

        for(int i = 0; i < answer.size(); i++){
            stringBuilder.append(answer.get(i)).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
