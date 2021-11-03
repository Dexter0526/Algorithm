package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스택
public class Ex10828 {
    private static int[] stack;
    private static int depth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        stack = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();

            switch (command){
                case "push":
                    push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "top":
                    System.out.println(top());
                    break;
                default:

            }
        }




    }

    private static void push(int number){
        stack[depth] = number;
        depth++;
    }

    private static int pop(){
        if(depth == 0) return -1;
        else{
            int number = stack[depth - 1];
            stack[depth - 1] = 0;
            depth--;
            return number;
        }

    }

    private static int size(){
        return depth;
    }

    private static int empty(){
        if(depth == 0) return 1;
        else return 0;
    }

    private static int top(){
        if(depth == 0) return -1;
        else return stack[depth - 1];
    }
}
