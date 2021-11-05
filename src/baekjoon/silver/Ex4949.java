package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 균형잡힌 세상
public class Ex4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while (true){
            line = bufferedReader.readLine();

            if(line.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            String answer = "yes";

            for(int i = 0; i < line.length(); i++){
                char temp = line.charAt(i);

                if(temp == '(' || temp == '[') stack.push(temp);
                else if(temp == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        answer = "no";
                        break;
                    }else{
                        stack.pop();
                    }
                }else if(temp == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = "no";
                        break;
                    } else {
                        stack.pop();
                    }
                }

            }

            if (stack.isEmpty() && answer.equals("yes")) answer = "yes";
            else answer = "no";

            stringBuilder.append(answer).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
