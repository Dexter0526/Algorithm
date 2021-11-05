package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 프린터 큐
public class Ex1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < T; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int count = 0;

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            int[] location = new int[N];

            for(int j = 0; j < N; j++){
                int priority = Integer.parseInt(stringTokenizer.nextToken());
                priorityQueue.add(priority);
                location[j] = priority;
            }

            while (!priorityQueue.isEmpty()){
                for(int j = 0; j < location.length; j++){
                    if(location[j] == priorityQueue.peek()){
                        if(M == j) {
                            priorityQueue.clear();
                            break;
                        }
                        count++;
                        priorityQueue.remove();
                    }
                }
            }

            stringBuilder.append(count + 1).append("\n");
        }

        System.out.println(stringBuilder);
    }

    public static class Doc implements Comparable<Doc> {
        private int importance;
        private int number;

        public Doc(int importance, int number){
            this.importance = importance;
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public int getImportance() {
            return importance;
        }

//        안정성 보장 X
        @Override
        public int compareTo(Doc o) {
            return o.getImportance() - this.importance;
        }
    }
}
