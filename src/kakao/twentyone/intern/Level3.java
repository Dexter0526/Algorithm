package kakao.twentyone.intern;

import java.util.Stack;

// 표 편집
public class Level3 {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        String answer = solution(n, k, cmd);
        System.out.println(answer);
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Integer> removeTable = new Stack<>();

        int tableSize = n;

        for (String row : cmd) {
            switch (row.charAt(0)) {
                case 'U':
                    k -= Integer.parseInt(row.substring(2));
                    break;
                case 'D':
                    k += Integer.parseInt(row.substring(2));
                    break;
                case 'C':
                    removeTable.add(k);
                    tableSize--;
                    if (k == tableSize) k--;
                    break;
                case 'Z':
                    if (k >= removeTable.pop()) k++;
                    tableSize++;
                    break;
                default:
                    break;
            }
        }

        StringBuilder builder = new StringBuilder();

        builder.append("O".repeat(tableSize));

        while (!removeTable.isEmpty()) {
            builder.insert(removeTable.pop(), "X");
        }

        answer = builder.toString();
        return answer;
    }
}
