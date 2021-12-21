package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 거짓말
public class Ex1043 {
    public static int[] relationship;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int known = Integer.parseInt(stringTokenizer.nextToken());
        HashSet<Integer> knownPeople = new HashSet<>();

        for(int i = 0; i < known; i++){
            knownPeople.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        relationship = new int[N + 1];
        HashSet<Integer>[] parties = new HashSet[M + 1];

        for(int i = 1; i <= N; i++) {
            relationship[i] = i;
        }
        for(int i = 1; i <= M; i++){
            parties[i] = new HashSet<>();
        }

        for(int i = 1; i <= M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int number = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());

            parties[i].add(a);

            while (number --> 1){
                int b = Integer.parseInt(stringTokenizer.nextToken());
                if(find(a) != find(b)) union(a, b);

                parties[i].add(b);

                a = b;
            }

        }

        HashSet<Integer> discovered = new HashSet<>();
        for(int i = 1; i <= N; i++){
            if(knownPeople.contains(i) && !discovered.contains(i)){
                int root = find(i);
                for(int j = 1; j <= N; j++){
                    if (find(j) == root) {
                        knownPeople.add(j);
                        discovered.add(j);
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= M; i++){
            boolean flag = false;
            for(int person : parties[i]){
                if(knownPeople.contains(person)){
                    flag = true;
                    break;
                }
            }

            if (!flag) answer++;
        }

        System.out.println(answer);
    }

    private static int find(int people){
        if(relationship[people] == people) return people;

        relationship[people] = find(relationship[people]);
        return relationship[people];
    }

    private static void union(int a, int b){
        int relation = find(b);
        relationship[relation] = a;
    }
}
