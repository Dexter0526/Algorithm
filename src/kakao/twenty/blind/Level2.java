package kakao.twenty.blind;

// 문자열 압축
public class Level2 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "aabbaccc";

        System.out.println(solution.solution(s));
    }

    private static class Solution {
        public int solution(String s) {
            int answer = s.length();

            for(int i = 1; i < s.length() / 2 + 1; i++){
                StringBuffer compression = new StringBuffer();
                String compare = s.substring(0, i);
                String end = "";
                int wordCount = 0;

                for(int j = i; j < s.length(); j += i){
                    if(j + i > s.length()) {
                        end = s.substring(j);
                        break;
                    }

                    if(compare.equals(s.substring(j, j + i))){
                        wordCount++;
                    }else{
                        compression.append(wordCount == 0 ? "" : Integer.toString(wordCount + 1));
                        compression.append(compare);

                        wordCount = 0;
                        compare = s.substring(j, j + i);
                    }
                }
                compression.append(wordCount == 0 ? "" : Integer.toString(wordCount + 1));
                compression.append(compare).append(end);

//                System.out.println(compression.toString());
                answer = Math.min(answer, compression.length());

            }

            return answer;
        }
    }
}

