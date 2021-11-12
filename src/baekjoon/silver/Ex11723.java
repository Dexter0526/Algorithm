package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 집합
public class Ex11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(bufferedReader.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < M; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            String command = stringTokenizer.nextToken();

            switch (command){
                case "add":
                    hashSet.add(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "remove":
                    hashSet.remove(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "check":
                    if(hashSet.contains(Integer.parseInt(stringTokenizer.nextToken()))){
                        stringBuilder.append(1).append("\n");
                    }else{
                        stringBuilder.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    int number = Integer.parseInt(stringTokenizer.nextToken());
                    if(hashSet.contains(number)){
                        hashSet.remove(number);
                    }else{
                        hashSet.add(number);
                    }
                    break;
                case "all":
                    hashSet.clear();
                    for(int j = 1; j <= 20; j++){
                        hashSet.add(j);
                    }
                    break;
                case "empty":
                    hashSet.clear();
                    break;
            }
        }

        System.out.println(stringBuilder);
    }
}
