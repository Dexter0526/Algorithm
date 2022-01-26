package programmers.monthly.season01;

import java.util.Arrays;

// 풍선 터트리기
public class Level3_1 {
    public static void main(String[] args) {
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int answer = a.length;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = a[0];
        right[a.length - 1] = a[a.length - 1];

        for(int i = 1; i < a.length - 1; i++){
            left[i] = Integer.min(left[i - 1], a[i]);
            right[a.length - i - 1] = Integer.min(right[a.length - i], a[a.length - i - 1]);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for(int i = 1; i < a.length - 1; i++){
            if(left[i] < a[i] && right[i] < a[i]) answer--;
        }

        return answer;
    }
}
