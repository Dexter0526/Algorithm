package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 큐
public class Ex10845 {
    private static int back = -1;
    private static int front = 0;
    private static int depth = 0;
    private static int[] queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        queue = new int[n];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();

            switch (command){
                case "push":
                    push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "pop":
//                    System.out.println(pop());
                    stringBuilder.append(pop()).append("\n");
                    break;
                case "size":
//                    System.out.println(getSize());
                    stringBuilder.append(getSize()).append("\n");
                    break;
                case "empty":
//                    System.out.println(empty());
                    stringBuilder.append(empty()).append("\n");
                    break;
                case "front":
//                    System.out.println(getFront());
                    stringBuilder.append(getFront()).append("\n");
                    break;
                case "back":
//                    System.out.println(getBack());
                    stringBuilder.append(getBack()).append("\n");
                    break;
                default:

            }
        }

        System.out.println(stringBuilder);
    }

    private static void push(int number){
        if(back == queue.length - 1) back = -1;
        back++;
        queue[back] = number;
        depth++;
    }

    private static int pop(){
        if(empty() == 1) return -1;
        if(front == queue.length) front = 0;
        int pop = queue[front];
        queue[front] = 0;

        front++;
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
        return queue[front];
    }

    private static int getBack(){
        if(empty() == 1) return -1;
        return queue[back];
    }
}
