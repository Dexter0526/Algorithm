package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// A → B
public class Ex16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long A = Long.parseLong(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());

        long answer = bfs(A, B);
        System.out.println(answer);
    }

    private static long bfs(long start, long end){
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{start, 1});

        while (!queue.isEmpty()){
            long[] now = queue.remove();

            if(now[0] == end) return now[1];

            if(now[0] * 2 <= end) queue.add(new long[]{now[0] * 2, now[1] + 1});

            if(now[0] * 10 + 1 <= end) queue.add(new long[]{now[0] * 10 + 1, now[1] + 1});
        }

        return -1;
    }
}
