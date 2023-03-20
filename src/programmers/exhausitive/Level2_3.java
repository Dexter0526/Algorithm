package programmers.exhausitive;

// 피로도
public class Level2_3 {
    static int max = 0;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        solution(k, dungeons);
        System.out.println(max);

    }

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];

        for (int i = 0; i < dungeons.length; i++){
            boolean entryAllowed = dungeons[i][0] <= k;
            visited[i] = true;
            dfs(visited, dungeons, 1, entryAllowed ? 1 : 0, entryAllowed ? k - dungeons[i][1] : k);
            visited[i] = false;
        }
        answer = max;
        return answer;
    }

    public static void dfs(boolean[] visited, int[][] dungeons, int dept, int enter, int health) {
        if (dept == visited.length) {
            System.out.println(enter);
            max = Math.max(max, enter);
            return;
        }

        for (int i = 0; i < dungeons.length; i++){
            if (visited[i]) continue;

            boolean entryAllowed = dungeons[i][0] <= health;

            visited[i] = true;
            dfs(visited, dungeons, dept + 1, entryAllowed ? enter + 1 : enter, entryAllowed ? health - dungeons[i][1] : health);
            visited[i] = false;
        }
    }
}
