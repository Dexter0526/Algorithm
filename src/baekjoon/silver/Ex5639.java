package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이진 검색 트리
public class Ex5639 {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(bufferedReader.readLine()));
        String number;

        while ((number = bufferedReader.readLine()) != null && !number.equals("")){
            Node node = new Node(Integer.parseInt(number));
            insertNode(node, root);
        }

        traversePostOrder(root);
        System.out.println(stringBuilder);
    }

//    후위 순회 출력
    private static void traversePostOrder(Node node){
        if(node == null) return;
        traversePostOrder(node.getLeft());
        traversePostOrder(node.getRight());
        stringBuilder.append(node.getData()).append("\n");
    }

//    트리 노드 삽입
    private static void insertNode(Node number, Node node){
        if(number.getData() > node.getData()){
            if(node.right == null){
                node.setRight(number);
            }else{
                insertNode(number, node.right);
            }
        }else{
            if(node.left == null){
                node.setLeft(number);
            }else{
                insertNode(number, node.left);
            }
        }
    }

    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getRight() {
            return right;
        }

        public Node getLeft() {
            return left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }
}
