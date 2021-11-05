package baekjoon.silver;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 카드2
public class Ex2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            deque.addLast(i);
        }

        while (deque.size() > 1){
            deque.removeFirst();
            deque.addLast(deque.removeFirst());
        }

        System.out.println(deque.remove());

    }
}
