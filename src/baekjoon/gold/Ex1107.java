package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// 리모컨
public class Ex1107 {
    public static boolean[] broken;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        broken = new boolean[10];
        int answer = Math.abs(N - 100);

        if(M != 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i = 0; i < M; i++){
                broken[Integer.parseInt(stringTokenizer.nextToken())] = true;
            }
        }

        for(int i = 0; i < 1000000; i++){
            if(check(i)) continue;

            answer = Math.min(answer, Integer.toString(i).length() + Math.abs(N - i));

            if(answer == 0) break;
        }

        System.out.println(answer);

    }

    private static boolean check(int number){
        for(int i = 0; i < 10; i++){
            if(broken[i] && Integer.toString(number).contains(Integer.toString(i))) return true;
        }

        return false;
    }

}
