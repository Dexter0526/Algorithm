package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 나이순 정렬
public class Ex10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Member[] members = new Member[n];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            members[i] = new Member(Integer.parseInt(stringTokenizer.nextToken()),
                    stringTokenizer.nextToken());

        }

        bufferedReader.close();

        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for(int i = 0; i < n; i++){
            stringBuilder.append(members[i].getAge()).append(" ");
            stringBuilder.append(members[i].getName()).append("\n");
        }

        System.out.println(stringBuilder);
    }

    public static class Member {
        private int age;
        private String name;

        public Member(int age, String name){
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

}
