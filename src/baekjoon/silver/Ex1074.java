package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Z
public class Ex1074 {
    public static int N;
    public static int r;
    public static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        divide(0, 0, (int) Math.pow(2, N), 0);
    }

    private static void divide(int x, int y, int size, int count){
        if(size == 2){
            for(int i = x; i <= x + 1; i++){
                for(int j = y; j <= y + 1; j++){
                    if(i == r && j == c) {
                        System.out.println(count);
                        return;
                    }
                    count++;
                }
            }
            return;
        }

        int resize = size / 2;

        if(x <= r && r < x + resize && y <= c && c < y + resize){
            divide(x, y, resize, count);
        }else if(x + resize <= r && r < x + size && y <= c && c < y + resize){
            divide(x + resize, y, resize, count + resize * resize * 2);
        }else if(x <= r && r < x + resize && y + resize <= c && c < y + size){
            divide(x, y + resize, resize, count + resize * resize);
        }else{
            divide(x + resize, y + resize, resize, count + resize * resize * 3);
        }

    }
}
