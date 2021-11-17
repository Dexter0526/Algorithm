package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 이중 우선순위 큐
public class Ex7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int N = Integer.parseInt(bufferedReader.readLine());

        while (N --> 0){
            int k = Integer.parseInt(bufferedReader.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            while (k --> 0){
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String command = stringTokenizer.nextToken();
                int n = Integer.parseInt(stringTokenizer.nextToken());

                if(command.equals("I")){
                    treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
                }else {
                    if(treeMap.isEmpty()) continue;
                    int key;

                    if(n > 0){
                        key = treeMap.lastKey();
                    }else{
                        key = treeMap.firstKey();
                    }

                    if(treeMap.get(key) > 1) treeMap.put(key, treeMap.get(key) - 1);
                    else treeMap.remove(key);

                }
            }

            if(treeMap.isEmpty()) stringBuilder.append("EMPTY").append("\n");
            else stringBuilder.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
