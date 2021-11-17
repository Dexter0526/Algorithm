package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// 절댓값 힙
public class Ex11286 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(bufferedReader.readLine());
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        StringBuilder stringBuilder = new StringBuilder();
//
//        while (N --> 0){
//            int command = Integer.parseInt(bufferedReader.readLine());
//
//            if(command == 0){
//                if(priorityQueue.isEmpty()) stringBuilder.append(0).append("\n");
//                else{
//                    int temp = priorityQueue.remove();
//                    if(hashMap.containsKey(-temp)){
//                        temp = -temp;
//                    }
//
//                    int count = hashMap.get(temp);
//                    count--;
//                    if(count == 0) hashMap.remove(temp);
//                    else hashMap.put(temp, count);
//
//                    stringBuilder.append(temp).append("\n");
//                }
//            }else {
//                priorityQueue.add(Math.abs(command));
//                if(hashMap.containsKey(command)) hashMap.put(command, hashMap.get(command) + 1);
//                else hashMap.put(command, 1);
//            }
//        }
//
//        System.out.println(stringBuilder);
//
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if(abs1 == abs2) return o1 - o2;
                return abs1 - abs2;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();

        while (N --> 0){
            int command = Integer.parseInt(bufferedReader.readLine());

            if(command == 0){
                if(priorityQueue.isEmpty()) stringBuilder.append(0).append("\n");
                else{
                    stringBuilder.append(priorityQueue.remove()).append("\n");
                }
            }else {
                priorityQueue.add(command);
            }
        }

        System.out.println(stringBuilder);

    }
}
