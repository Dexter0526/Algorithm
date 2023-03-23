package programmers.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;

// 아이템 줍기
public class Level3_4 {
    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        int answer = solution(rectangle, characterX, characterY, itemX, itemY);
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        Boolean[][] matrix = new Boolean[102][102];

        for (int[] coordinate : rectangle) {
            int x1 = 2 * coordinate[0];
            int y1 = 2 * coordinate[1];
            int x2 = 2 * coordinate[2];
            int y2 = 2 * coordinate[3];

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    if (matrix[j][k] != null && !matrix[j][k]) continue;
                    matrix[j][k] = (j == x1 || j == x2 || k == y1 || k == y2);
                }
            }
        }

        answer = findItem(matrix, 2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY);
        return answer / 2;
    }

    private static int findItem(Boolean[][] matrix, int characterX, int characterY, int itemX, int itemY) {
        Node position = new Node(characterX, characterY, 1);
        Queue<Node> bfs = new LinkedList<>();
        bfs.add(position);
        matrix[position.getX()][position.getY()] = false;

        while (!bfs.isEmpty()) {
            position = bfs.poll();
            if (position.getX() == itemX && position.getY() == itemY) {
                return position.getCount();
            }

            for (MOVE move : MOVE.values()) {
                int moveX = position.getX() + move.getX();
                int moveY = position.getY() + move.getY();

                if (matrix[moveX][moveY] == null || !matrix[moveX][moveY]) continue;
                if (moveX < 0 || moveY < 0 || moveX >= matrix.length || moveY >= matrix[0].length) continue;

                matrix[moveX][moveY] = false;
                bfs.add(new Node(moveX, moveY, position.getCount() + 1));
            }
        }

        return -1;
    }

    private enum MOVE {
        LEFT(0, -1), RIGHT(0, 1), UP(-1, 0), DOWN(1, 0);

        private int x;
        private int y;

        MOVE(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    private static class Node {
        private int x;
        private int y;
        private int count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }
}
