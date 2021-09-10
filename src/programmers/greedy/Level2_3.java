package programmers.greedy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 큰 수 만들기
public class Level2_3 {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
//        "775841"
        String answer = solution(number, k);
        System.out.println(answer);
    }
    public static String solution(String number, int k) {
        String answer = "";
//        int count = number.length() - k;
        StringBuilder sb = new StringBuilder();

//        List<String> convert = Stream.of(number.split("")).collect(Collectors.toList());

        int index = 0;

        for(int i = 0; i < number.length() - k; i++){
            char max = 0;
//            String numbers_max = Collections.max(convert.subList(index, k + i + 1));
//            index += convert.subList(index, k + i + 1).indexOf(numbers_max) + 1;
//            answer += numbers_max;
            for(int j = index; j <= k + i; j++){
                System.out.println(j);
                if(max < number.charAt(j)){
                    index = j + 1;
                    max = number.charAt(j);
                }
            }
//            answer += max;
            sb.append(max);
        }

        return sb.toString();
    }
}

// 참고
//class Solution {
//    public String solution(String number, int k) {
//        StringBuilder sb = new StringBuilder();
//        int index = 0;
//        int max = 0;
//        for(int i=0; i<number.length() - k; i++) {
//            max = 0;
//            for(int j = index; j<= k+i; j++) {
//                if(max < number.charAt(j)-'0') {
//                    max = number.charAt(j)-'0';
//                    index = j+1;
//                }
//            }
//            sb.append(max);
//        }
//        return sb.toString();
//    }
//}

// 참고
//class Solution {
//    public String solution(String number, int k) {
//        char[] result = new char[number.length() - k];
//        Stack<Character> stack = new Stack<>();
//
//        for (int i=0; i<number.length(); i++) {
//            char c = number.charAt(i);
//            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
//                stack.pop();
//            }
//            stack.push(c);
//        }
//        for (int i=0; i<result.length; i++) {
//            result[i] = stack.get(i);
//        }
//        return new String(result);
//    }
//}

