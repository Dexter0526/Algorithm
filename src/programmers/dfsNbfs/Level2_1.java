package programmers.dfsNbfs;

// 타켓넘버
public class Level2_1 {
    public static void main(String[] args) {
//        numbers	target	return
//[1, 1, 1, 1, 1]	3	5
    }

    public int solution(int[] numbers, int target) {
        return DFS(numbers, target, 0, 0);
    }

    public int DFS(int[] numbers, int target, int index, int num) {
        if(index == numbers.length) {
            return num == target ? 1 : 0;
        } else {
            return DFS(numbers, target, index + 1, num + numbers[index])
                    + DFS(numbers, target, index + 1, num - numbers[index]);
        }
    }
}
