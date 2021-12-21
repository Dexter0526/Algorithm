package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수 6
public class Ex11444 {
    public static final long MOD = 1_000_000_007;
    public static long[][] initMatrix = {{1, 1} , {1, 0}};

//    시간초과
//    public static void main(String[] args) throws IOException {
//        final long MOD = 1_000_000_007;
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        long n = Long.parseLong(bufferedReader.readLine());
//        long first = 0;
//        long second = 1;
//
//        for(long i = 2; i <= n; i++){
//            long temp = (first + second) % MOD;
//            first = second % MOD;
//            second = temp;
////            System.out.println(second);
//        }
//
//        System.out.println(second);
//
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long[][] matrix = {{1, 1}, {1, 0}};
        long N = Long.parseLong(bufferedReader.readLine());

        System.out.println(pow(matrix, N - 1)[0][0]);
    }

    private static long[][] pow(long[][] matrix, long exp){
        if(exp == 1 || exp == 0) return matrix;

        long[][] ret = pow(matrix, exp / 2);
        ret = multiply(ret, ret);

        if(exp % 2 == 1) {
            ret = multiply(ret, initMatrix);
        }

        return ret;
    }

    private static long[][] multiply(long[][] o1, long[][] o2){
        long[][] ret = new long[2][2];

        for(int k = 0; k < 2; k++){
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }

        return ret;
    }
}
