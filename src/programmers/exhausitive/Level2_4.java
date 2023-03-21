package programmers.exhausitive;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

// 전력망을 둘로 나누기
public class Level2_4 {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int answer = solution(n, wires);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] wires) {
        int answer = 100;

        Tower tower = new Tower(n);

        for (int[] wire : wires) {
            tower.addWire(wire[0], wire[1]);
        }

        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];

            tower.removeWires(start, end);
            // TODO: 2023/03/21 start logic(bfs)
            int visitedTower = tower.cuttingWire();

            answer = Math.min(answer, Math.abs(n - 2 * visitedTower));
            // TODO: 2023/03/21 end logic
            tower.addWire(start, end);
        }


        return answer;
    }

    static class Tower {
        private int total;
        private HashSet<Integer> wires[];

        public Tower(int total) {
            this.total = total;
            this.wires = new HashSet[total + 1];

            for (int i = 0; i <= total; i++) {
                this.wires[i] = new HashSet<>();
            }
        }

        public void addWire(int start, int end) {
            this.wires[start].add(end);
            this.wires[end].add(start);
        }

        public HashSet<Integer> getWires(int start) {
            return this.wires[start];
        }

        public void removeWires(int start, int end) {
            this.wires[start].remove(end);
            this.wires[end].remove(start);
        }

        public int cuttingWire() {
            Queue<Integer> towerQueue = new PriorityQueue<>();
            boolean[] visited = new boolean[this.total + 1];
            int visitedTower = 0;

            for (int i = 1; i < visited.length; i++) {
                visited[i] = false;
            }

            towerQueue.addAll(this.getWires(1));
            visited[1] = true;

            while (!towerQueue.isEmpty()) {
                int tower = towerQueue.poll();
                if (visited[tower]) continue;
                visited[tower] = true;

                for (int i : this.getWires(tower)){
                    if (!visited[i]) towerQueue.add(i);
                }
            }

            for (int i = 1; i < visited.length; i++) {
                if (visited[i]) visitedTower++;
            }

            return visitedTower;
        }
    }
}
