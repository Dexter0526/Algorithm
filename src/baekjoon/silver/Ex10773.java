package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 제로
public class Ex10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i = 0; i < K; i++){
            int temp = Integer.parseInt(bufferedReader.readLine());
            if(!stack.isEmpty() && temp == 0){
                stack.pop();
            }else{
                stack.push(temp);
            }
        }

        while (!stack.isEmpty()){
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
