package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 거짓말
public class Ex1043 {
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

        HashSet<Integer>[] parties = new HashSet[M + 1];
        for(int i = 1; i <= M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        }
    }
}
