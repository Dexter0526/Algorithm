package programmers.dp;

// 정수 삼각형
public class Level3_2 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(triangle);
    }
//    Bottom-up
    public static int solution(int[][] triangle) {
        int answer = 0;

        for(int i = triangle.length - 2; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                System.out.println(i + " " + j);
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        return answer = triangle[0][0];
    }
}
