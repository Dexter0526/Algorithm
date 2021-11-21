package programmers.dp;

// N으로 표현
public class Level3_1 {
    public static void main(String[] args) {
        System.out.println(solution(5, 12) == 4);
    }

    public static int minCount = Integer.MAX_VALUE;
    public static int solution(int N, int number) {
        int answer = 0;
        dfs(N, number, 0, 0);
        return answer = (minCount > 8 ? -1 : minCount);
    }

    private static void dfs(int N, int number, int now, int depth){
        if(depth > 8) return;

        if(now == number){
            minCount = Math.min(minCount, depth);
            return;
        }
        int newN = N;
        for(int i = 0; i < 8 - depth; i++){
            dfs(N, number, now + newN, depth + i + 1);
            dfs(N, number, now - newN, depth + i + 1);
            dfs(N, number, now * newN, depth + i + 1);
            dfs(N, number, now / newN, depth + i + 1);
//             ex) 55, 555 ....
            newN = newN * 10 + N;
        }

    }
}
