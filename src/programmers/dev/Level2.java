package programmers.dev;

// 행렬 테두리 회전하기
public class Level2 {
    public static void main(String[] args) {
//rows	columns	queries	result
//6	6	[[2,2,5,4],[3,3,6,6],[5,1,6,3]]	[8, 10, 25]
//3	3	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
//100	97	[[1,1,100,97]]	[1]
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4},{3, 3, 6, 6},{5, 1, 6, 3}};
        solution(rows, columns, queries);
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows + 1][columns + 1];
        int count = 1;

        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                matrix[i][j] = count++;
            }
        }

        for(int i = 0; i < queries.length; i++){
            answer[i] = rotate(matrix, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }

        return answer;
    }

    private static int rotate(int[][] matrix, int x1, int y1, int x2, int y2){
        int init = matrix[x1][y1];
        int min = init;

        for(int i = x1; i < x2; i++){
            matrix[i][y1] = matrix[i + 1][y1];
            min = Math.min(min, matrix[i][y1]);
        }

        for (int i = y1; i < y2; i++) {
            matrix[x2][i] = matrix[x2][i + 1];
            min = Math.min(min, matrix[x2][i]);
        }

        for (int i = x2; i > x1; i--) {
            matrix[i][y2] = matrix[i - 1][y2];
            min = Math.min(min, matrix[i][y2]);
        }

        for (int i = y2; i > y1; i--) {
            matrix[x1][i] = matrix[x1][i - 1];
            min = Math.min(min, matrix[x1][i]);
        }

        matrix[x1][y1 + 1] = init;
        return min;
    }
}
