package programmers.exhausitive;

import java.util.LinkedList;

// 모음 사전
public class Level2_5 {
    private static LinkedList<String> dictionary = new LinkedList<>();

    public static void main(String[] args) {
        int answer = solution("I");
        System.out.println(answer);
    }

    public static int solution(String word) {
        int answer = 0;
        String alphabets = "AEIOU";

        for (int i = 0; i < alphabets.length(); i++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(alphabets.charAt(i));

            makeDictionary(alphabets, 0, stringBuilder);
        }

//        while (true){
//            if (dictionary.get(answer).equals(word)) break;
//
//            answer++;
//        }

        answer = dictionary.indexOf(word);

        return answer + 1;
    }

    public static void makeDictionary(String alphabets, int depth, StringBuilder dictionaryWord) {
        if (depth == 5) return;
        dictionary.add(dictionaryWord.toString());

        for (int i = 0; i < alphabets.length(); i++){
            dictionaryWord.append(alphabets.charAt(i));
            makeDictionary(alphabets, depth + 1, dictionaryWord);
            dictionaryWord.deleteCharAt(dictionaryWord.length() - 1);
        }
    }
}
