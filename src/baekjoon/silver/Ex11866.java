package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 요세푸스 문제 0
public class Ex11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Deque<Integer> circle = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            circle.addLast(i);
        }
        stringBuilder.append("<");

        while (circle.size() > 1){
            int count = 0;
            for(int i = 0; i < K; i++){
                count++;
                int remove = circle.removeFirst();
                if(K == count) {
                    stringBuilder.append(remove).append(", ");
                    break;
                }
                circle.addLast(remove);
            }
        }

        stringBuilder.append(circle.remove()).append(">");

        System.out.println(stringBuilder);
    }
}
