package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 정렬하기 3
public class Ex10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] number = new int[n];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(number);

        for(int i = 0; i < n; i++){
            stringBuilder.append(number[i]).append("\n");
        }

        System.out.println(stringBuilder);
    }

//    참고 자료 (https://st-lab.tistory.com/107)
//    빈도(카운팅 정렬)
//    public static void main(String[] args) throws IOException {
//        // 수의 범위 (0 ~ 10000) 사실상 0은 제외
//        int[] cnt = new int[10001];
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            // 해당 인덱스의 값을 1 증가
//            cnt[Integer.parseInt(br.readLine())] ++;
//        }
//
//        br.close();
//
//        StringBuilder sb = new StringBuilder();
//
//        // 0은 입력범위에서 없으므로 1부터 시작
//        for(int i = 1; i < 10001; i++){
//            // i 값이 개수가 0 이 될 때 까지 출력 (빈도수를 의미)
//            while(cnt[i] > 0){
//                sb.append(i).append('\n');
//                cnt[i]--;
//            }
//        }
//        System.out.println(sb);
//    }
}
