package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호
public class Ex9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < n; i++){
            String bracket = bufferedReader.readLine();
            Stack<Character> bucket = new Stack<>();
            boolean isVPS = true;

            for(int j = 0; j < bracket.length(); j++){
                char temp = bracket.charAt(j);
                if(temp == '(') bucket.push(temp);
                else if(bucket.isEmpty()) {
                    isVPS = false;
                    break;
                }else{
                    bucket.pop();
                }
            }

            if(!bucket.isEmpty()) isVPS = false;

            if(isVPS) stringBuilder.append("YES").append("\n");
            else stringBuilder.append("NO").append("\n");
        }

        System.out.println(stringBuilder);
    }
}
