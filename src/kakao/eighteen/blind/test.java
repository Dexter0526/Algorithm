package kakao.eighteen.blind;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		FailureRate test = new FailureRate();
		
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		System.out.println(Arrays.toString(test.solution(N, stages)));
	}
}
