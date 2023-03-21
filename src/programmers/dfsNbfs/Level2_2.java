package programmers.dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단거리
public class Level2_2 {

    private static int min = Integer.MAX_VALUE;

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

    public static void main(String[] args) {
//        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps = {{1, 1, 1, 1}, {1,1, 1, 1}};
        System.out.println(solution(maps));

    }

    public static int solution(int[][] maps) {
        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 0) visited[i][j] = true;
                else if (maps[i][j] == 1) visited[i][j] = false;
                else visited[i][j] = false;
            }
        }

        if (visited[0][1] && visited[1][0] && visited[1][1]) return -1;
        if (visited[visited.length - 1][visited[0].length - 1] && visited[0][visited[0].length - 1] && visited[visited.length - 1][0])
            return -1;
        visited[0][0] = true;
//        dfs(visited, 0, 0, 1);
        bfs(visited, 0, 0, 1);

        answer = (min == Integer.MAX_VALUE) ? answer : min;

        return answer;
    }

    public static void dfs(boolean[][] visited, int x, int y, int depth) {
        if ((x == visited.length - 1) && y == visited[x].length - 1) {
            min = Math.min(min, depth);
            return;
        }

        for (MOVE move : MOVE.values()) {
            int moveX = x + move.getX();
            int moveY = y + move.getY();

            if (moveX < 0) continue;
            if (moveY < 0) continue;
            if (moveX >= visited.length) continue;
            if (moveY >= visited[0].length) continue;
            if (visited[moveX][moveY]) continue;

            visited[moveX][moveY] = true;
            dfs(visited, moveX, moveY, depth + 1);
            visited[moveX][moveY] = false;
        }
    }

    public static void bfs(boolean[][] visited, int x, int y, int depth) {
        Queue<int[]> queue = new LinkedList<>();
        int[] now = {x, y, depth};
        queue.add(now);

        while (!queue.isEmpty()) {
            now = queue.poll();

            if ((now[0] == visited.length - 1) && (now[1] == visited[x].length - 1)) {
                min = Math.min(min, now[2]);
                return;
            }

            for (MOVE move : MOVE.values()) {
                int moveX = now[0] + move.getX();
                int moveY = now[1] + move.getY();

                if (moveX < 0) continue;
                if (moveY < 0) continue;
                if (moveX >= visited.length) continue;
                if (moveY >= visited[0].length) continue;
                if (visited[moveX][moveY]) continue;

                visited[moveX][moveY] = true;

                int[] next = {moveX, moveY, now[2] + 1};

                queue.add(next);
            }
        }
    }
}
