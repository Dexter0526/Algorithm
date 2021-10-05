package kakao.twenty.intern;

import java.util.*;

// 거리두기 확인하기
// https://www.youtube.com/watch?v=jdUg2NYBAyM (강의)
public class Level2 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = solution(places);
        System.out.println(Arrays.toString(answer));
    }

    static class Point{
        int row, col, dist;

        Point(int r, int c, int d){
            row = r;
            col = c;
            dist = d;
        }
    }

    static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean bfs(String[] place, int row, int col){
        boolean[][] visited = new boolean[5][5];

        Queue<Point> q = new LinkedList<>();
        visited[row][col] = true;
        q.add(new Point(row, col, 0));

        while (!q.isEmpty()){
            Point curr = q.remove();

            if(curr.dist > 2) continue;
            if(curr.dist != 0 && place[curr.row].charAt(curr.col) == 'P'){
                return false;
            }

            for(int i = 0; i < 4; i++){
                int nr = curr.row + D[i][0], nc = curr.col + D[i][1];
                if(nr < 0 || nr > 4 || nc < 0 || nc > 4) continue;
                if(visited[nr][nc]) continue;
                if(place[nr].charAt(nc) == 'X') continue;
                visited[nr][nc] = true;
                q.add(new Point(nr, nc, curr.dist+1));
            }
        }

        return true;
    }

    static boolean check(String[] place){
        for(int r = 0; r < 5; r++){
            for(int c = 0; c < 5; c++){
                if(place[r].charAt(c) == 'P'){
                    if(bfs(place, r, c) == false) {
                        System.out.println("false");
                        return false;
                    }

                }
            }
        }
        return true;
    }

    public static int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[places.length];

        System.out.println(Arrays.toString(answer));

        for(int i = 0; i < 5; i++){
            if(check(places[i])) answer[i] = 1;
            else answer[i] = 0;
        }

        return answer;
    }
}
