package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 치킨 배달
public class Ex15686 {
    public static int N;
    public static int M;
    public static ArrayList<Point> house = new ArrayList<>();
    public static ArrayList<Point> chicken = new ArrayList<>();
    public static Point[] select;
    public static int answer = Integer.MAX_VALUE;
    public static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < N; j++){
                int category = Integer.parseInt(stringTokenizer.nextToken());
                if(category == 1) house.add(new Point(i, j));
                else if(category == 2) chicken.add(new Point(i, j));
            }
        }

        isVisit = new boolean[chicken.size()];
        select = new Point[M];

        combination(0, 0);
        System.out.println(answer);
    }

    private static void combination(int depth, int start){
        if(depth == M) {
//            for(int i = 0; i < select.length; i++){
//                System.out.println(select[i].x + " " + select[i].y);
//            }
//            System.out.println("==========================================");
            answer = Math.min(answer, chickenStreet());
            return;
        }

        for(int i = start; i < chicken.size(); i++){
            if(!isVisit[i]) {
                isVisit[i] = true;
                select[depth] = chicken.get(i);
                combination(depth + 1, i);
                isVisit[i] = false;
            }
        }
    }

    private static int chickenStreet(){
        int sum = 0;

        for(int i = 0; i < house.size(); i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < M; j++){
                int dist = Math.abs(house.get(i).x - select[j].x) + Math.abs(house.get(i).y - select[j].y);
                min = Math.min(min, dist);
            }
            sum += min;
        }

        return sum;
    }



    public static class Point{
        private int x;
        private int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
