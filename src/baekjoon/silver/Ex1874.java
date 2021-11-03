package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

// 스택 수열
public class Ex1874 {
//    배열 사용
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());
        int start = 0;

//        String answer = array(bufferedReader, stringBuilder, n, start);
        String answer = stack(bufferedReader, stringBuilder, n, start);

        System.out.println(answer);
    }

//    배열 사용
    private static String array(BufferedReader bufferedReader, StringBuilder stringBuilder, int n, int start) throws IOException {
        int[] stackArray = new int[n];
        int depth = 0;

        for(int i = 0; i < n; i++){
            int number = Integer.parseInt(bufferedReader.readLine());

            if(stackArray[depth] < number) {
                for(int j = start + 1; j <= number; j++){
                    stackArray[depth] = j;
                    depth++;
                    stringBuilder.append("+").append("\n");
                }
                start = number;
            }else if(stackArray[depth - 1] != number){
                return "NO";
            }

            depth--;
            stringBuilder.append("-").append("\n");
        }

        return stringBuilder.toString();
    }

//    스택 사용
    private static String stack(BufferedReader bufferedReader, StringBuilder stringBuilder, int n, int start) throws IOException {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int number = Integer.parseInt(bufferedReader.readLine());

            if(start < number) {
                for(int j = start + 1; j <= number; j++){
                    stack.push(j);
                    stringBuilder.append("+").append("\n");
                }
                start = number;
            }else if(stack.peek() != number){
                return "NO";
            }

            stack.pop();
            stringBuilder.append("-").append("\n");
        }

        return stringBuilder.toString();
    }

}
