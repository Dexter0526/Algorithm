package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_38 {
    public static void main(String[] args) {

        List<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");

        List<String> result = new ArrayList<>();
        recursion(arr, result, arr.size(), 2);

    }

    private static void recursion(List<String> arr, List<String> result, int n, int r) {

        if (r == 0) {
            String temp = "";
            System.out.println(result.toString());
            for(String item : result){
                temp +=item;
            }
            System.out.println(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(arr.remove(i));
            recursion(arr, result, n - 1, r - 1);
            arr.add(i, result.remove(result.size() - 1));
        }
    }
}
