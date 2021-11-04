package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 수 정렬하기2
public class Ex2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
//        int[] numbers = new int[n];
        ArrayList<Integer> numbers = new ArrayList();


        for(int i = 0; i < n; i++){
//            numbers[i] = Integer.parseInt(bufferedReader.readLine());
            numbers.add(i);
        }

//        퀵 정렬
//        quickSort(numbers, 0, numbers.length - 1);

//
//        Arrays.sort(numbers);

//        병합정렬
        Collections.sort(numbers);

        System.out.println(numbers.toString());
    }

//    퀵 sort
    private static void quickSort(int[] numbers, int left, int right){
        if(left >= right) return;

        int pivot = selectPivot(numbers, left, right);

        quickSort(numbers, left, pivot - 1);
        quickSort(numbers, pivot + 1, right);
    }

    private static int selectPivot(int[] numbers, int left, int right){
        int pivot = numbers[right];
        int i = left;

        for(int j = left; j < right; j++){
            if(numbers[j] < pivot){
                swap(numbers, i, j);
                i++;
            }
        }

        swap(numbers, i, right);

        return i;
    }

    private static void swap(int[] number, int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }

}
