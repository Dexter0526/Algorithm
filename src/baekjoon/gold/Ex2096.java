package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내려가기
public class Ex2096 {
    public static int N;
//    public static int[][] board;
    public static int[][][] scoreBoard;
    public static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
//        board = new int[N][3];
        scoreBoard = new int[N][3][2];

        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            scoreBoard[i][0][0] = Integer.parseInt(stringTokenizer.nextToken());
            scoreBoard[i][1][0] = Integer.parseInt(stringTokenizer.nextToken());
            scoreBoard[i][2][0] = Integer.parseInt(stringTokenizer.nextToken());

            scoreBoard[i][0][1] = scoreBoard[i][0][0];
            scoreBoard[i][1][1] = scoreBoard[i][1][0];
            scoreBoard[i][2][1] = scoreBoard[i][2][0];
        }

        for(int i = 0; i < N - 1; i++){
            scoreBoard[i + 1][0][0] += Math.max(scoreBoard[i][0][0], scoreBoard[i][1][0]);
            scoreBoard[i + 1][1][0] += Math.max(scoreBoard[i][0][0], Math.max(scoreBoard[i][1][0], scoreBoard[i][2][0]));
            scoreBoard[i + 1][2][0] += Math.max(scoreBoard[i][1][0], scoreBoard[i][2][0]);

            scoreBoard[i + 1][0][1] += Math.min(scoreBoard[i][0][1], scoreBoard[i][1][1]);
            scoreBoard[i + 1][1][1] += Math.min(scoreBoard[i][0][1], Math.min(scoreBoard[i][1][1], scoreBoard[i][2][1]));
            scoreBoard[i + 1][2][1] += Math.min(scoreBoard[i][1][1], scoreBoard[i][2][1]);
        }

//        for(int i = 0; i < 3; i++){
//            search(N - 1, i);
//        }
//
        int[] answer = new int[2];
        answer[0] = scoreBoard[N - 1][0][0];
        answer[1] = scoreBoard[N - 1][0][1];
        for(int i = 1; i < 3; i++){
            answer[0] = Math.max(answer[0], scoreBoard[N - 1][i][0]);
            answer[1] = Math.min(answer[1], scoreBoard[N - 1][i][1]);
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

//    private static void search(int depth, int index){
//        if(depth == 0) return;
//        int max = 0;
//        int min = Integer.MAX_VALUE;
//
//        for(int i = 0; i < 3; i++){
//            int newIndex = index + dx[i];
//            if(newIndex >= 0 && newIndex < 3){
//                max = Math.max(max, scoreBoard[depth][newIndex][0]);
//                min = Math.min(min, scoreBoard[depth][newIndex][1]);
//            }
//        }
//
//        scoreBoard[depth-1][index][0] += max;
//        scoreBoard[depth-1][index][1] += min;
//        search(depth - 1, index);
//    }
}
