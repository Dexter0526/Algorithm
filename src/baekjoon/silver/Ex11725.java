package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 트리의 부모 찾기
public class Ex11725 {
    public static int N;
    public static ArrayList<Integer>[] neighbor;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        N = Integer.parseInt(bufferedReader.readLine());
        neighbor = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            neighbor[i] = new ArrayList<Integer>();
        }

        parent = new int[N + 1];
        for(int i = 1; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            neighbor[A].add(B);
            neighbor[B].add(A);
        }

//        for(int i = 1; i <= N; i++){
//            System.out.println(neighbor[i]);
//        }

        parent[1] = 1;
        dfs(1);

        for(int i = 2; i <= N; i++){
            stringBuilder.append(parent[i]).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void dfs(int number){
        ArrayList<Integer> neighborList = neighbor[number];

        if(neighborList.isEmpty()) return;

        for(int i = 0; i < neighborList.size(); i++){
            if(parent[neighborList.get(i)] == 0){
                parent[neighborList.get(i)] = number;
                dfs(neighborList.get(i));
            }
        }
    }
}
