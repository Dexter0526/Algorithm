package hello.ch09;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String word_1 = "hish";
        String word_2 = "fish";

        int[][] cell = new int[word_1.length()][word_2.length()];

        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < cell[i].length; j++){
                if(word_1.charAt(i) == word_2.charAt(j)){
                    if(i > 0 && j > 0){
                        cell[i][j] = cell[i-1][j-1] + 1;
                    }else{
                        cell[i][j] = 1;
                    }
                }else{
                    if (i == 0 && j > 0) {
                        cell[i][j] = cell[i][j-1];
                    } else if (i > 0 && j == 0) {
                        cell[i][j] = cell[i-1][j];
                    } else if (i > 0 && j > 0) {
                        cell[i][j] = Math.max(cell[i-1][j], cell[i][j-1]);
                    } else {
                        cell[i][j] = 0;
                    }
                }
            }
        }

        for(int[] item : cell){
            System.out.println(Arrays.toString(item));
        }
    }
}
