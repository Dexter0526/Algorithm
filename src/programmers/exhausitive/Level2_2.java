package programmers.exhausitive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 소수찾기
public class Level2_2 {
    static ArrayList<String> stringCombination = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
//        numbers	return
//                "17"	3
//        "011"	2

        String numbers = "17";
        int answer = solution(numbers);

        System.out.println(answer);
    }

    public static int solution(String numbers) {
        int answer = 0;

//        set.add(Integer.parseInt(numbers));
        List<Character> temp = numbers.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//        char[] temp = numbers.toCharArray();
        for(int i = 1; i <= temp.size(); i++){
            // 사용 예시: permutation(arr, 0, n, 4);
            permutation(temp, 0, temp.size(), i);
        }
//        permutation(temp, 0, temp.size(), 2);

        for(Integer item : set){
            System.out.println("item:::" + item);
            if(item > 2){
                boolean decimal = true;
                for(int i = 2; i * i <= item; i++){
                    if(item % i == 0) {
                        decimal = false;
                        System.out.println("break i:::" + i);
                        System.out.println("break item:::" + item);
                        break;
                    }
                }
                if(decimal) answer++;
            }else if(item == 2) answer++;
        }

        return answer;
    }

    public static void nCr(char[] str, int r, String result){
        if(r == 0){
            set.add(Integer.parseInt(result));
            return;
//            return Integer.parseInt(result);
        }else{
            for(int i = 0; i < str.length; i++){
                nCr(str, r-1, result+str[i]);
            }
        }
    }

    public static void recursion(List<Character> arr, List<Character> result, int n, int r) {

        if (r == 0) {
            String temp = "";
            System.out.println(result.toString());
            for(Character item : result){
                temp +=item;
            }
            System.out.println(temp);

            set.add(Integer.parseInt(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(arr.remove(i));
            recursion(arr, result, n - 1, r - 1);
            arr.add(i, result.remove(result.size() - 1));
        }
    }

// 순서 없이 n 개중에서 r 개를 뽑는 경우
// 사용 예시: permutation(arr, 0, n, 4);
    public static void permutation(List<Character> arr, int depth, int n, int r) {
        if (depth == r) {
//            String temp = "";
//            System.out.println(arr.toString());
//            for(Character item : arr){
//                temp +=item;
//            }
//            System.out.println(temp);
//
//            set.add(Integer.parseInt(temp));
            print(arr, r);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
//            swap(arr, depth, i);
        }
    }

    public static void swap(List<Character> arr, int depth, int i) {
        Character temp = arr.get(depth);
        arr.set(depth, arr.get(i));
        arr.set(i,temp);
    }

    public static void print(List<Character> arr, int r) {
        System.out.println(arr.toString());
        String temp = "";
        for (int i = 0; i < r; i++){
//            System.out.print(arr.get(i) + " ");
            temp += arr.get(i);
        }
        System.out.println(temp);

        set.add(Integer.parseInt(temp));
        System.out.println();
    }
}
