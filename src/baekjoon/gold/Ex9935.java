package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문자열 폭발
public class Ex9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String explosion = bufferedReader.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < line.length(); i++){
            stack.push(line.charAt(i));

            if(stack.size() >= explosion.length()){
                int length = 0;
                for(int j = 0; j < explosion.length(); j++){
                    if(explosion.charAt(j) != stack.get(stack.size() - explosion.length() + j)) break;

                    length++;
                }
                if(length == explosion.length()){
                    for(int j = 0; j < explosion.length(); j++) stack.pop();
                }
            }
        }

        if(stack.size() == 0) System.out.println("FRULA");
        else {
            StringBuilder stringBuilder = new StringBuilder();
            for(char c : stack) stringBuilder.append(c);
            System.out.println(stringBuilder);
        }
    }

//    메모리 초과
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String line = bufferedReader.readLine();
//        String explosion = bufferedReader.readLine();
//
//        while (line.contains(explosion)){
//            line = line.replaceAll(explosion, "");
//        }
//
//        System.out.println(line.length() == 0 ? "FRULA" : line);
//    }
}
