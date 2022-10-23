package kakao.twentyone.intern;

import java.util.HashMap;
import java.util.Map;

// 숫자 문자열과 영단어
public class Level1 {

    public static void main(String[] args) {
//        s	result
//"one4seveneight"	1478
//"23four5six7"	234567
//"2three45sixseven"	234567
//"123"	123
        String s = "one4seveneight";
        int answer = solution(s);
        System.out.println(answer);
    }

    public static int solution(String s) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        String temp = "";

        Map<String, Integer> numbers = new HashMap<>();

        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);

        char[] sSplit = s.toCharArray();
        for(char item : sSplit){
            System.out.println(item);
            if(item > 96){
                temp += item;
                if(numbers.containsKey(temp)){
                    System.out.println(temp);
                    sb.append(numbers.get(temp));
                    temp = "";
                }

            }else{
                sb.append(item);
            }
        }

        answer = Integer.parseInt(sb.toString());

        return answer;
    }

//    참고
//    public int solution(String s) {
//        int answer = 0;
//        StringBuilder sb = new StringBuilder("");
//        int len = s.length();
//        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
//        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
//
//        for(int i=0; i<10; i++){
//            s = s.replaceAll(alphabets[i],digits[i]);
//        }
//
//        return Integer.parseInt(s);
//    }
}
