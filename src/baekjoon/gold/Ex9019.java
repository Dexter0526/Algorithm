package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DSLR
public class Ex9019 {
    public static boolean[] isVisit = new boolean[10000];
    public static String[] answer = new String[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T --> 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            isVisit = new boolean[10000];
            answer = new String[10000];
            bfs(A, B);
            stringBuilder.append(answer[B]).append("\n");

        }

        System.out.println(stringBuilder);
    }

    private static void bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisit[start] = true;
        answer[start] = "";

        while (!queue.isEmpty()){
            int now = queue.remove();
            if(isVisit[end]) break;

            int d = d(now);
            int s = s(now);
            int l = l(now);
            int r = r(now);

            if(!isVisit[d]) {
                queue.add(d);
                isVisit[d] = true;
                answer[d] = answer[now] + "D";
            }
            if(!isVisit[s]) {
                queue.add(s);
                isVisit[s] = true;
                answer[s] = answer[now] + "S";
            }
            if(!isVisit[l]) {
                queue.add(l);
                isVisit[l] = true;
                answer[l] = answer[now] + "L";
            }
            if(!isVisit[r]) {
                queue.add(r);
                isVisit[r] = true;
                answer[r] = answer[now] + "R";
            }

        }

    }

    private static int d(int number){
        long temp = number * 2;
        if(temp > 9999) return (int) temp % 10000;
        return (int) temp;
    }

    private static int s(int number){
        if(number == 0) return 9999;
        return number - 1;
    }

    private static int l(int number){
        return number / 1000 + (number % 1000) * 10;
    }

    private static int r(int number){
        return number / 10 + (number % 10) * 1000;
    }
}
