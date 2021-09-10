package programmers.dev;

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
        int[] answer = {};
        int[][] matrix = new int[rows][columns];
        int count = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                count++;
                matrix[i][j] = count;
            }
        }


        return answer;
    }
}
