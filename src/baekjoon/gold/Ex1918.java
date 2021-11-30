package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위 표기식
public class Ex1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < line.length(); i++){
            char temp = line.charAt(i);
            switch (temp){
                case '+' :
                case '-' :
                case '/' :
                case '*' :
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(temp)){
                        stringBuilder.append(stack.pop());
                    }
                    stack.push(temp);
                    break;
                case '(' :
                    stack.push(temp);
                    break;
                case ')' :
                    while (!stack.isEmpty()){
                        if(stack.peek() == '('){
                            stack.pop();
                            break;
                        }
                        stringBuilder.append(stack.pop());
                    }
                    break;
                default:
                    stringBuilder.append(temp);
                    break;

            }
        }

        while (!stack.isEmpty()) stringBuilder.append(stack.pop());


        System.out.println(stringBuilder);
    }

    private static int priority(char c){
        if(c == '(') return 0;
        else if(c == '+' || c == '-') return 1;
        else return 2;
    }
}
