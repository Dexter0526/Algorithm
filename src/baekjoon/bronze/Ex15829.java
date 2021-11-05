package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Hashing
public class Ex15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(bufferedReader.readLine());
        String alphabet = bufferedReader.readLine();
        int r = 31;
        int m = 1234567891;

        long sum = 0;
        for (int i = 0; i < alphabet.length(); i++){
            int temp = alphabet.charAt(i) - 96;
            long pow = 1;

            for(int j = 0; j < i; j++){
                pow = pow * r % m;
            }

            sum += temp * pow;
        }

        bufferedReader.close();

        System.out.println(sum % m);

    }
}
