package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 별 찍기 - 11
public class Ex2448 {
    public static int N;
    public static String[] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        stars = new String[N];
        stars[0] = "  *  ";
        stars[1] = " * * ";
        stars[2] = "*****";

        makeStars(3);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < N; i++){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(stars[i]);
            while (stringBuffer.length() != stars[N - 1].length()){
                stringBuffer.insert(0, " ");
                stringBuffer.insert(stringBuffer.length(), " ");
            }
//            System.out.println(stringBuffer.length());
            stringBuilder.append(stringBuffer).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void makeStars(int depth){
        if(depth == N) return;

        for(int i = depth; i < 2 * depth; i++){
//            복사할 때 길이를 해당 깊이의 바닥 길이와 비교 후 공백처리
            int lineLength = (stars[depth - 1].length() - stars[i - depth].length()) / 2;
//            System.out.println(depth + " " + lineLength);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stars[i - depth]);

            for(int j = 0; j < lineLength; j++){
                stringBuilder.insert(0, " ");
                stringBuilder.insert(stringBuilder.length(), " ");
            }

            stars[i] = stringBuilder.toString() + " " + stringBuilder.toString();
//            System.out.println(stars[i]);
        }

        makeStars(2 * depth);
    }
}
