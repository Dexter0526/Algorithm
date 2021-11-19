package baekjoon.silver;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 비밀번호 찾기
public class Ex17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        저장된 사이트 주소의 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
//        비밀번호를 찾으려는 사이트 주소의 수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        HashMap<String, String> passwordMap = new HashMap<>();

        while (N --> 0){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String website = stringTokenizer.nextToken();
            String password = stringTokenizer.nextToken();

            passwordMap.put(website, password);
        }

        while (M --> 0){
            String website = bufferedReader.readLine();
            bufferedWriter.append(passwordMap.get(website)).append("\n");
        }

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
