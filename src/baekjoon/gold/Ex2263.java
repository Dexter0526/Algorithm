package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리의 순회
public class Ex2263 {
    public static int n;
    public static int[] inorder;
    public static int[] postorder;
    public static int[] preorder;
    public static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        n = Integer.parseInt(bufferedReader.readLine());

        inorder = new int[n];
        postorder = new int[n];
        preorder = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++){
            inorder[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++){
            postorder[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        makePreorder(0, n - 1, 0, n - 1);
        for(int i : preorder){
            stringBuilder.append(i).append(" ");
        }

        System.out.println(stringBuilder);
    }

    private static void makePreorder(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart <= inEnd && postStart <= postEnd){
            preorder[index++] = postorder[postEnd];
            int root = inStart;
            for(int i = inStart; i <= inEnd; i++){
                if(inorder[i] == postorder[postEnd]){
                    root = i;
                    break;
                }
            }

            makePreorder(inStart, root - 1, postStart, postStart + root - inStart - 1);
            makePreorder(root + 1, inEnd, postStart + root - inStart, postEnd - 1);
        }

    }
}
