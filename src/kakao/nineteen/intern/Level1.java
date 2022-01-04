package kakao.nineteen.intern;

import java.util.Stack;

// 크레인 인형뽑기 게임
public class Level1 {

    public static void main(String[] args) {

    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        int[] count = new int[board.length];
        Stack<Integer> bucket = new Stack<>();

        for(int i = 0; i < moves.length; i++){
            int select = moves[i] - 1;

            while (count[select] != board.length){
                if(board[count[select]][select] != 0){
                    int pick = board[count[select]][select];

                    if(!bucket.isEmpty() && bucket.peek() == pick) {
                        bucket.pop();
                        answer += 2;
                    }
                    else bucket.push(pick);

                    count[select]++;

                    break;
                }

                count[select]++;
            }
        }

        return answer;
    }
}
