package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 최대 힙
public class Ex11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < N; i++){
            int line = Integer.parseInt(bufferedReader.readLine());
            if(line == 0){
                if(priorityQueue.isEmpty()) stringBuilder.append(0).append("\n");
                else stringBuilder.append(priorityQueue.remove()).append("\n");
            }else{
                priorityQueue.add(line);
            }
        }

        System.out.println(stringBuilder);
    }
}
