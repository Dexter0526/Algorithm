package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 아기 상어
public class Ex16236 {
    public static int N;
    public static int[][] matrix;
    public static boolean[][] isVisit;
    public static int[] shark = new int[3];
    public static int eat = 0;
    public static ArrayList<Fish> eatList = new ArrayList<>();
    public static int[] dx = {0, -1, 1, 0};
    public static int[] dy = {1, 0, 0, -1};
    public static int second = 0;

    public static class Fish{
        private int x;
        private int y;
        private int distance;

        public Fish(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[N][N];
        isVisit = new boolean[N][N];
        shark[2] = 2;

        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(matrix[i][j] == 9){
                    shark[0] = i;
                    shark[1] = j;
                }
            }
        }
        matrix[shark[0]][shark[1]] = 0;

        while (true){
//            탐색
            bfs(shark[0], shark[1]);
            
//            탐색 종료후 식사
            if(!eatList.isEmpty() && eatList.size() != 0){
                eat();
            }else break;
        }

        System.out.println(second);
    }

    private static void bfs(int x, int y){
        Queue<Fish> queue = new LinkedList<>();
        isVisit = new boolean[N][N];

        queue.add(new Fish(x, y, 0));
        isVisit[x][y] = true;

        while (!queue.isEmpty()){
            Fish fish = queue.remove();
//            탐색
            for(int i = 0; i < 4; i++){
                int newX = fish.getX() + dx[i];
                int newY = fish.getY() + dy[i];

                if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                    if(!isVisit[newX][newY] && matrix[newX][newY] < shark[2] && matrix[newX][newY] != 0){
                        eatList.add(new Fish(newX, newY, fish.getDistance() + 1));
                    }

                    if(!isVisit[newX][newY] && matrix[newX][newY] <= shark[2]){
                        queue.add(new Fish(newX, newY, fish.getDistance() + 1));
                        isVisit[newX][newY] = true;
                    }

                }
            }
        }

    }

    private static void eat(){
//        if(eatList.isEmpty()) {
//            System.out.println("break");
//            return;
//        }

//        거리 -> x좌표 -> y좌표 순으로 정렬
        Collections.sort(eatList, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if(o1.getDistance() == o2.getDistance()){
                    if(o1.getX() == o2.getX()){
                        return o1.getY() - o2.getY();
                    }else{
                        return o1.getX() - o2.getX();
                    }
                }else{
                    return o1.getDistance() - o2.getDistance();
                }
            }
        });

        Fish eatFish = eatList.get(0);
        eat++;
        shark[0] = eatFish.getX();
        shark[1] = eatFish.getY();

        if(eat == shark[2]){
            shark[2]++;
            eat = 0;
        }

        second += eatFish.getDistance();
        matrix[eatFish.getX()][eatFish.getY()] = 0;
        eatList.clear();
    }

}
