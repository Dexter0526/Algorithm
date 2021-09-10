package programmers.dfsNbfs;

import java.util.*;

// 여행경로
// 추후 스택, bfs 시도
public class Level3_3 {
    public static boolean[] check;
    public static List<String> results;

    public static void main(String[] args) {
//        tickets	return
//[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
//[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        solution(tickets);
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        check = new boolean[tickets.length];
        results = new LinkedList<>();

//        List<String[]> list = Stream.of(tickets).sorted((o1, o2) -> o1[1].compareTo(o2[1])).collect(Collectors.toList());

//        List<String> convert = new LinkedList<>();
//        convert.add("ICN");
        dfs(tickets, "ICN", "ICN", 0, check);
        Collections.sort(results);

        System.out.println(results.toString());
        answer = results.get(0).split(":");

        return answer;
    }

    public static void dfs(String[][] tickets, String temp, String node, int count, boolean[] check){
        System.out.println("count:::" + count);
        if(count == tickets.length) {
            results.add(temp);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            if(check[i]){
                continue;
            }

            if(tickets[i][0].equals(node)){
                check[i] = true;
//                temp += ":" + tickets[i][1];
                dfs(tickets, temp + ":" + tickets[i][1], tickets[i][1], count + 1, check);
                check[i] = false;
                System.out.println(temp);
            }

        }
        return;
    }
}
