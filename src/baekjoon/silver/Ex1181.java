package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단어 정렬
public class Ex1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] words;
        Set<String> inputWords = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < n; i++){
            inputWords.add(bufferedReader.readLine());
        }

        words = inputWords.toArray(String[]::new);

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        });

        for(int i = 0; i < words.length; i++){
            stringBuilder.append(words[i]).append("\n");
        }


        System.out.println(stringBuilder);
    }
}
