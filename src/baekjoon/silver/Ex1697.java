package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class Ex1697 {
    public static int[] isVisit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        if(N == K) System.out.println(0);
        else {
            bfs(N, K);
            System.out.println(isVisit[K] - 1);
        }


    }

    private static void bfs(int start, int K){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisit[start] = 1;

        while (!queue.isEmpty()){
            int temp = queue.remove();

            for(int i = 0; i < 3; i++){
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    isVisit[next] = isVisit[temp] + 1;
                    return;
                }
                if (next >= 0 && next < isVisit.length && isVisit[next] == 0) {
                    queue.add(next);
                    isVisit[next] = isVisit[temp] + 1;
                }
            }
        }
    }
}
