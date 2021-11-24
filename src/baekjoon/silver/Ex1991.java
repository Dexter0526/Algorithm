package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 트리 순회
public class Ex1991 {
    public static HashMap<Character, Node> hashMap = new HashMap<>();
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char root = stringTokenizer.nextToken().charAt(0);
            char left = stringTokenizer.nextToken().charAt(0);
            char right = stringTokenizer.nextToken().charAt(0);

            Node node = new Node(left, right);
            hashMap.put(root, node);
        }

        traversePreOrder('A');
        stringBuilder.append("\n");
        traverseInorder('A');
        stringBuilder.append("\n");
        traversePostOrder('A');

        System.out.println(stringBuilder);
    }

    private static void traversePreOrder(char root){
        if(root == '.') return;

        stringBuilder.append(root);
        traversePreOrder(hashMap.get(root).left);
        traversePreOrder(hashMap.get(root).right);
    }

    private static void traverseInorder(char root){
        if(root == '.') return;

        traverseInorder(hashMap.get(root).left);
        stringBuilder.append(root);
        traverseInorder(hashMap.get(root).right);
    }

    private static void traversePostOrder(char root){
        if(root == '.') return;

        traversePostOrder(hashMap.get(root).left);
        traversePostOrder(hashMap.get(root).right);
        stringBuilder.append(root);
    }

    public static class Node{
        private char left;
        private char right;

        public Node(char left, char right){
            this.left = left;
            this.right = right;
        }
    }
}
