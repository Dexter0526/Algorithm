package programmers.dfsNbfs;



// 단어변환
public class Level3_2 {

    public static boolean[] visited;
    public static int answer;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int answer = solution(begin, target, words);
        System.out.println(answer);
    }

    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = words.length;

        dfs(begin, target, words, 0);

        return answer == words.length ? 0 : answer;
    }

    public static void dfs(String begin, String target, String[] words, int count){
        if(begin.equals(target)) {
            answer = (answer > count) ? count : answer;

            return;
        }

        for(int i = 0; i < words.length; i++){
            if(visited[i]){
                continue;
            }

            int check = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) check++;
            }

            if(check == begin.length() - 1){
                System.out.println(begin);
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }

//    참고
//    static class Node {
//        String next;
//        int edge;
//
//        public Node(String next, int edge) {
//            this.next = next;
//            this.edge = edge;
//        }
//    }
//
//    public int solution(String begin, String target, String[] words) {
//        int n = words.length, ans = 0;
//
//        // for (int i=0; i<n; i++)
//        //  if (words[i] != target && i == n-1) return 0;
//
//        Queue<Node> q = new LinkedList<>();
//
//
//        boolean[] visit = new boolean[n];
//        q.add(new Node(begin, 0));
//
//        while(!q.isEmpty()) {
//            Node cur = q.poll();
//            if (cur.next.equals(target)) {
//                ans = cur.edge;
//                break;
//            }
//
//            for (int i=0; i<n; i++) {
//                if (!visit[i] && isNext(cur.next, words[i])) {
//                    visit[i] = true;
//                    q.add(new Node(words[i], cur.edge + 1));
//                }
//            }
//        }
//
//        return ans;
//    }

}
