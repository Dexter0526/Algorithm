package programmers.dp;

// 도둑질
public class Level4_1 {
    public static void main(String[] args) {

    }

    public static int solution(int[] money) {
        int answer = 0;
        int[] thiefFirst = new int[money.length];
        int[] thiefSecond = new int[money.length];

//        첫번째 집 훔치고 마지막 스킵
        thiefFirst[0] = money[0];
        thiefFirst[1] = money[0];

//        첫번째 집 스킵하고 두번째 집 훔침
        thiefSecond[1] = money[1];


        for(int i = 2; i < money.length; i++){
            thiefFirst[i] = Math.max(thiefFirst[i - 2] + money[i] , thiefFirst[i - 1]);
            thiefSecond[i] = Math.max(thiefSecond[i - 2] + money[i] , thiefSecond[i - 1]);
        }

        return answer = Math.max(thiefFirst[money.length - 2], thiefSecond[money.length - 1]);
    }
}
