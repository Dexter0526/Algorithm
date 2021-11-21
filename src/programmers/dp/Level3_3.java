package programmers.dp;

// 등굣길
public class Level3_3 {
    public static int distance = Integer.MAX_VALUE;
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};
    public static int mod = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] matrix = new int[m + 1][n + 1];

        for(int i = 0; i < puddles.length; i++){
            matrix[puddles[i][0]][puddles[i][1]] = -1;
        }

        matrix[1][1] = 1;

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][j] == -1) continue;
                for(int k = 0; k < 2; k++){
                    if(matrix[i - dx[k]][j - dy[k]] > 0){
                        matrix[i][j] += matrix[i - dx[k]][j - dy[k]] % mod;
                    }

                }
            }
        }

        return answer = matrix[m][n] % mod;
    }
}
