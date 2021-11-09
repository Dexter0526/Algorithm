package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 잃어버린 괄호
public class Ex1541 {
//    무식하게 풀기
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String line = bufferedReader.readLine();
//        StringBuilder stringBuilder = new StringBuilder();
//        int answer = 0;
//        boolean isPlus = true;
//
//        for(int i = 0; i < line.length(); i++){
//            if(line.charAt(i) == '+'){
//                if(isPlus){
//                    answer += Integer.parseInt(stringBuilder.toString());
//                }else{
//                    answer -= Integer.parseInt(stringBuilder.toString());
//                }
//                stringBuilder = new StringBuilder();
//            }else if(line.charAt(i) == '-'){
//                if(isPlus){
//                    answer += Integer.parseInt(stringBuilder.toString());
//                }else{
//                    answer -= Integer.parseInt(stringBuilder.toString());
//                }
//                isPlus = false;
//                stringBuilder = new StringBuilder();
//            }else{
//                stringBuilder.append(line.charAt(i));
//            }
//        }
//
//        if(isPlus){
//            answer += Integer.parseInt(stringBuilder.toString());
//        }else{
//            answer -= Integer.parseInt(stringBuilder.toString());
//        }
//
//        System.out.println(answer);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), "-");
        int count = Integer.MAX_VALUE;

        while (stringTokenizer.hasMoreTokens()){
            StringTokenizer minus = new StringTokenizer(stringTokenizer.nextToken(), "+");

            int temp = 0;
            while (minus.hasMoreTokens()){
                temp += Integer.parseInt(minus.nextToken());
            }
            if(count == Integer.MAX_VALUE){
                count = temp;
            }else{
                count -= temp;
            }

        }

        System.out.println(count);
    }
}
