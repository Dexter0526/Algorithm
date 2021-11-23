package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
public class Ex11053 {
    public static int[] number;
    public static HashSet[] dpSet;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        number = new int[N];
        dpSet = new HashSet[N];
        dp = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

//        dp count
        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(number[i] > number[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }

            answer = Math.max(answer, dp[i]);
        }

//        dp 부분 집합
//        for(int i = 0; i < N; i++){
//            dpSet[i] = new HashSet();
//            dpSet[i].add(number[i]);
//            for(int j = 0; j < i; j++){
//                if(number[i] > number[j]){
//                    dpSet[i].add(number[j]);
//                }
//            }
//            System.out.println(dpSet[i]);
//            answer = Math.max(answer, dpSet[i].size());
//        }

        System.out.println(answer);


    }

}
