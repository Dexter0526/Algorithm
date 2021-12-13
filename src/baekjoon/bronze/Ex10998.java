package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A×B
public class Ex10998 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        System.out.println(Integer.parseInt(stringTokenizer.nextToken()) * Integer.parseInt(stringTokenizer.nextToken()));
    }
}
