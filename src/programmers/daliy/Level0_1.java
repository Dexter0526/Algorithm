package programmers.daliy;

public class Level0_1 {
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        int answer = solution(babbling);
        System.out.println(answer);
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        for (String speck : babbling){
            boolean duple = false;

            for (SPECK speckEnum : SPECK.values()){
                if (speck.contains(speckEnum.name().concat(speckEnum.name()))){
                    duple = true;
                    break;
                }
            }

            if (!duple){
                for (SPECK speckEnum : SPECK.values()){
                    speck = speck.replaceAll(speckEnum.name(), "");
                }
            }

            if (speck.length() == 0) answer++;
        }

        return answer;
    }

    private enum SPECK{
        aya, ye, woo, ma
    }
}
