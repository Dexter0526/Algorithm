package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 나는야 포켓몬 마스터 이다솜
public class Ex1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] pokemon = new String[N];

        for(int i = 0; i < N; i++){
            String line = bufferedReader.readLine();
            pokemon[i] = line;
            hashMap.put(line, i);
        }

        for(int i = 0; i < M; i++){
            String line = bufferedReader.readLine();
            if(line.charAt(0) < 60){
                stringBuilder.append(pokemon[Integer.parseInt(line) - 1]).append("\n");
            }else{
                stringBuilder.append(hashMap.get(line) + 1).append("\n");
            }
        }

        System.out.println(stringBuilder);

    }
}
