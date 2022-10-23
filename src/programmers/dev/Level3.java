package programmers.dev;

import java.util.HashMap;
import java.util.Map;

// 다단계 칫솔 판매
public class Level3 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] answer = solution(enroll, referral, seller, amount);
        for (int i : answer){
            System.out.println(i);
        }
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Person> relationShipMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            relationShipMap.put(
                    enroll[i],
                    new Person(enroll[i], 0, relationShipMap.getOrDefault(referral[i], null))
            );
        }

        for (int i = 0; i < seller.length; i++) {
            Person person = relationShipMap.get(seller[i]);
            person.calculateAmount(amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++){
            answer[i] = relationShipMap.get(enroll[i]).amount;
        }

        return answer;
    }


}

class Person {
    String name;
    Integer amount;
    Person parent;

    public Person(String name, Integer amount, Person parent) {
        this.name = name;
        this.amount = amount;
        this.parent = parent;
    }

    public void calculateAmount(Integer amount) {
        int calculateFee = amount / 10;
        this.amount += amount - calculateFee;

        if (this.parent != null)
            this.parent.calculateAmount(calculateFee);
    }

}