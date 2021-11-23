package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N-Queen
public class Ex9663 {
    public static int[] chess;
    public static int N;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        chess = new int[N];
        nQueen(0);

        System.out.println(answer);
    }

    private static void nQueen(int depth){
        if(depth == N){
            answer++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(possibility(depth, i)){
                chess[depth] = i;
                nQueen(depth + 1);
            }
        }
    }

    private static boolean possibility(int depth, int index){
//            이미 존재하는 인덱스 검사
        for(int i = 0; i < depth; i++){
//            ex {0, x, x, x} if i = 0, index = 0 ... skip
            if(chess[i] == index) return false;
//            if chess[0] = 1, depth = 1, -> i = 0 index = 0 skip, i = 0 index = 2 skip
            else if(Math.abs(i - depth) == Math.abs(chess[i] - index)) return false;
        }
        return true;
    }
}
