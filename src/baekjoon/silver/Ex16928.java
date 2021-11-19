package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀과 사다리 게임
public class Ex16928 {
    public static int[] cache = new int[101];
    public static HashMap<Integer, Integer> move = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

//        사다리 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
//        뱀 수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        while (N --> 0){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            move.put(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }

        while (M --> 0){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            move.put(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }
        bfs();
        System.out.println(cache[100]);
    }

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisit = new boolean[101];
        queue.add(1);
        cache[1] = 0;
        isVisit[1] = true;

        while (!queue.isEmpty()){

//            현재 위치
            int position = queue.remove();
//            System.out.println(position);
            if(position == 100) return;

            for(int i = 1; i <= 6; i++){
                int x = position + i;
                if(x > 100) continue;
                if(isVisit[x]) continue;
                isVisit[x] = true;

                if(move.containsKey(x)){
                    if(!isVisit[move.get(x)]){
                        int jump = move.get(x);
                        queue.add(jump);
                        cache[jump] = cache[position] + 1;
                        isVisit[jump] = true;
                    }
                }else{
                    queue.add(x);
                    cache[x] = cache[position] + 1;
//                        if(x == 12) System.out.println("why 12??");
                }

            }
        }
    }

}
