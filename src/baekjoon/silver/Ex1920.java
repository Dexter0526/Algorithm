package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 수 찾기
public class Ex1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        HashSet<Integer> existence = new HashSet<>();

        for(int i = 0; i < n; i++){
            existence.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; i < m; i++){
            if(existence.contains(Integer.parseInt(stringTokenizer.nextToken()))){
                stringBuilder.append(1).append("\n");
            }else{
                stringBuilder.append(0).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}
