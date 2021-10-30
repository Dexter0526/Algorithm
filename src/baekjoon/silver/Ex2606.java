package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 바이러스
public class Ex2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, ArrayList> graph = new HashMap<>();

        while (true){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            ArrayList temp = new ArrayList();
            if(stringTokenizer == null) break;
            if(!stringTokenizer.hasMoreTokens()) break;

            int node = Integer.parseInt(stringTokenizer.nextToken());

            if(graph.containsKey(node)){
                temp = graph.get(node);
            }

            if(stringTokenizer.hasMoreTokens()){
                temp.add(stringTokenizer.nextToken());
            }

            graph.put(node, temp);
        }

        for(Integer item : graph.keySet()){
            System.out.println("key ::: " + item);
            System.out.println("values ::: " + graph.get(item).toString());
        }
    }
}
