package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 좌표 압축
public class Ex18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

//        입력
        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(stringTokenizer.nextToken());
            numbers[i] = number;
        }

//        정렬
        int[] sortNumbers = numbers.clone();
        Arrays.sort(sortNumbers);
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
//        카운팅 저장
        for(int i = 0; i < sortNumbers.length; i++){
            if(!rankMap.containsKey(sortNumbers[i])){
                rankMap.put(sortNumbers[i], rank);
                rank++;
            }
        }

        for(int i = 0; i < N; i++){
            stringBuilder.append(rankMap.get(numbers[i])).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
