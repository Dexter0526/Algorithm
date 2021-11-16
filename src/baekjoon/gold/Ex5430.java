package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// AC
public class Ex5430 {
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < T; i++){
            String command = bufferedReader.readLine();
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), "[],");
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            while (stringTokenizer.hasMoreTokens()){
                deque.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            AC(deque, command);
        }

        System.out.println(stringBuilder);
    }

    private static void AC(ArrayDeque<Integer> deque, String command){
        boolean direction = true;

        for(char cmd : command.toCharArray()){
            if(cmd == 'R') direction = !direction;
            else{
//                if(deque.isEmpty()) {
//                    stringBuilder.append("error").append("\n");
//                    return;
//                }

                if(direction){
                    if(deque.pollFirst() == null){
                        stringBuilder.append("error").append("\n");
                        return;
                    }

                }else{
                    if(deque.pollLast() == null){
                        stringBuilder.append("error").append("\n");
                        return;
                    }
                }
            }
        }

//        출력
        stringBuilder.append("[");
        if(!deque.isEmpty()){
            if(direction){
                stringBuilder.append(deque.pollFirst());
                while (!deque.isEmpty()){
                    stringBuilder.append(",").append(deque.pollFirst());
                }
            }else{
                stringBuilder.append(deque.pollLast());
                while (!deque.isEmpty()){
                    stringBuilder.append(",").append(deque.pollLast());
                }
            }
        }
        stringBuilder.append("]").append("\n");
    }

}
