package programmers.monthly.season02;

import java.util.Stack;

// 괄호 회전하기
public class Level2_1 {
    public static void main(String[] args) {

        System.out.println(solution("[](){}"));
    }

    public static int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++){
            Stack<Character> stack = new Stack<Character>();
            int index = i;
            boolean check = true;

            for(int j = 0; j < s.length(); j++){
                switch (s.charAt(index)){
                    case '[':
                    case '{':
                    case '(':
                        stack.add(s.charAt(index));
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                        else check = false;
                        break;
                    case '}':
                        if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                        else check = false;
                        break;
                    case ')':
                        if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                        else check = false;
                        break;
                    default:
                        break;
                }
                if(!check) break;

                index++;
                if(index == s.length()) index = 0;
            }

            if(check && stack.isEmpty()) answer++;
        }

        return answer;
    }
}
