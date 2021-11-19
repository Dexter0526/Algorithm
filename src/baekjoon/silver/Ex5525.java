package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// IOIOI
public class Ex5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int S = Integer.parseInt(bufferedReader.readLine());

        String text = bufferedReader.readLine();
        int count = 0;
        int answer = 0;

//        OI 체크
//        int[] dp = new int[S];

//        for(int i = 1; i < text.length() - 1; i++){
//            if(text.charAt(i) != text.charAt(i + 1) && text.charAt(i) == 'O'){
//                dp[i + 1] = dp[i - 1] + 1;
//
//                if(dp[i + 1] >= N && text.charAt(i - 2 * N + 1) == 'I') count++;
//            }
//        }

//        IOI 체크
        for(int i = 1; i < text.length() - 1; i++){
            if(text.charAt(i - 1) == 'I' && text.charAt(i) == 'O' && text.charAt(i + 1) == 'I'){
                count++;
                if(count == N) {
                    count--;
                    answer++;
                }
                i++;
            } else{
                count = 0;
            }
        }

//        System.out.println(Arrays.toString(dp));

        System.out.println(answer);

    }
}
