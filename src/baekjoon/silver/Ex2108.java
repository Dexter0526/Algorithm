package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 통계학
public class Ex2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] frequency = new int[8001];
        double sum = 0;
        int[] numbers = new int[n];

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(bufferedReader.readLine()) + 4000;
            frequency[temp]++;
        }

        bufferedReader.close();
        int index = 0;
        int frequencyMax = 0;
        Queue<Integer> queue = new LinkedList<>();

//        카운팅 정렬
        for(int i = 0; i < 8001; i++){
            if(frequency[i] > 0){
                int temp = frequency[i];

                if(frequencyMax == temp) queue.add(i - 4000);
                else if(frequencyMax < temp) {
                    queue.clear();
                    frequencyMax = temp;
                    queue.add(i - 4000);
                }
                for(int j = 1; j <= temp; j++){
                    numbers[index] = i - 4000;
                    sum += i - 4000;
                    index++;
                }
            }
        }
        if(queue.size() > 1) {
            queue.poll();
        }

        System.out.println(Math.round(sum / n));
        System.out.println(numbers[n / 2]);
        System.out.println(queue.poll());
        System.out.println(numbers[n - 1] - numbers[0]);
    }
}
