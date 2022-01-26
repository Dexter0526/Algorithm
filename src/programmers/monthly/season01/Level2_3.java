package programmers.monthly.season01;

// 쿼드압축 후 개수 세기
public class Level2_3 {
    private static int[] answer = new int[2];

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        solution(arr);

        System.out.println(answer[0] + "  " + answer[1]);
    }

    public static int[] solution(int[][] arr) {
        divide(0, 0, arr.length, arr);

        return answer;
    }

    private static void divide(int x, int y, int size, int[][] arr){
        if(check(x, y, size, arr)) return;

        int resize = size / 2;
        divide(x, y, resize, arr);
        divide(x, y + resize, resize, arr);
        divide(x + resize, y, resize, arr);
        divide(x + resize, y + resize, resize, arr);
    }

    private static boolean check(int x, int y, int size, int[][] arr){
        int number = arr[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != number) return false;
            }
        }

        answer[number]++;
        return true;
    }
}
