package Algorithm.src.programmers.level1;

import java.util.Arrays;

public class Level1_Testing {
	public static void main(String[] args) {
		
		// testcase
		int[] arr = {5,0,2,7};
		
		Level1_43 test = new Level1_43();

		//return
		int[] answer = test.solution(arr);

		System.out.println(Arrays.toString(answer));
		
	}
}
