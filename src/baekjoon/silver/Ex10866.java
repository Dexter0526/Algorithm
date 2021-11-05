package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 덱
public class Ex10866 {
    private static int back;
    private static int front;
    private static int depth = 0;
    private static int[] deque;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        deque = new int[n * 2 + 1];
        front = n;
        back = n;

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();

            switch (command){
                case "push_front":
                    push_front(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "pop_front":
                    stringBuilder.append(pop_front()).append("\n");
                    break;
                case "pop_back":
                    stringBuilder.append(pop_back()).append("\n");
                    break;
                case "size":
                    stringBuilder.append(getSize()).append("\n");
                    break;
                case "empty":
                    stringBuilder.append(empty()).append("\n");
                    break;
                case "front":
                    stringBuilder.append(getFront()).append("\n");
                    break;
                case "back":
                    stringBuilder.append(getBack()).append("\n");
                    break;
                default:

            }
        }

        System.out.println(stringBuilder);
    }

    private static void push_back(int number){
        back++;
        deque[back] = number;
        depth++;
    }

    private static void push_front(int number){
        deque[front] = number;
        front--;
        depth++;
    }

    private static int pop_front(){
        if(empty() == 1) return -1;
        front++;
        int pop = deque[front];
        deque[front] = 0;
        depth--;
        return pop;
    }

    private static int pop_back(){
        if(empty() == 1) return -1;

        int pop = deque[back];
        deque[back] = 0;
        back--;
        depth--;
        return pop;
    }

    private static int getSize(){
        return depth;
    }

    private static int empty(){
        if(depth == 0) return 1;
        else return 0;
    }

    private static int getFront(){
        if(empty() == 1) return -1;
        return deque[front + 1];
    }

    private static int getBack(){
        if(empty() == 1) return -1;
        return deque[back];
    }
}
