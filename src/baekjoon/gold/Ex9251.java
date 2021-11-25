package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// LCS
public class Ex9251 {
    public static String firstLine;
    public static String secondLine;
    public static int[][] LCS;
    public static char[] LCSArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        firstLine = bufferedReader.readLine();
        secondLine = bufferedReader.readLine();
        LCS = new int[firstLine.length() + 1][secondLine.length() + 1];

//        for(int i = 0; i < firstLine.length(); i++){
//            for (int j = 0; j < secondLine.length(); j++){
//                if(firstLine.charAt(i) == secondLine.charAt(j)){
//                    LCS[i + 1][j + 1] = LCS[i][j] + 1;
//                }else{
//                    LCS[i + 1][j + 1] = Math.max(LCS[i][j + 1], LCS[i + 1][j]);
//                }
//            }
//        }

        LCSRecursive(firstLine.length() - 1, secondLine.length() - 1);
        LCSArray = new char[LCS[firstLine.length()][secondLine.length()]];
        searchLCSArray(firstLine.length(), secondLine.length(), LCS[firstLine.length()][secondLine.length()]);

        System.out.println(LCS[firstLine.length()][secondLine.length()]);
        System.out.println(Arrays.toString(LCSArray));

        for(int i = 0; i < LCS.length; i++){
            System.out.println(Arrays.toString(LCS[i]));
        }
    }

//    재귀
    private static int LCSRecursive(int i, int j){
        if(i == -1 || j == -1) return 0;

        if(firstLine.charAt(i) == secondLine.charAt(j)){
            LCS[i + 1][j + 1] = LCSRecursive(i - 1, j - 1) + 1;
        }else{
            LCS[i + 1][j + 1] = Math.max(LCSRecursive(i - 1, j), LCSRecursive(i, j - 1));
        }

        return LCS[i + 1][j + 1];
    }

    private static void searchLCSArray(int x, int y, int count){
        if(x == 0 || y == 0) return;

        if(LCS[x][y] == LCS[x - 1][y]){
            searchLCSArray(x - 1, y, count);
        }else if(LCS[x][y] == LCS[x][y - 1]){
            searchLCSArray(x, y - 1, count);
        }else{
            LCSArray[count - 1] = firstLine.charAt(x - 1);
            searchLCSArray(x - 1, y - 1, count - 1);
        }
    }
}
