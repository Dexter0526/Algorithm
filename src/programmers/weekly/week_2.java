package programmers.weekly;

// 2주차 상호 평가
public class week_2 {
    public static void main(String[] args) {
//        int[][] scores = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};
        int[][] scores = {{50, 90}, {50, 87}};
        String answer = solution(scores);
        System.out.println(answer);
    }

    public static String solution(int[][] scores) {
        String answer = "";
        for(int i = 0; i < scores.length; i++){
            int max = 0;
            int min = 100;
            int score = 0;

            for(int j = 0; j < scores.length; j++){
                int temp = scores[j][i];
                if (i != j){
                    if(temp > max) max = temp;
                    else if(temp < min) min = temp;
                }
                score +=  temp;
            }

            if(scores[i][i] > max || scores[i][i] < min){
                score -= scores[i][i];
                score = score / (scores.length - 1);
            }else{
                score = score / scores.length;
            }
            System.out.println(score);
            answer += scoreToGrade(score);
        }

        return answer;
    }

    public static String scoreToGrade(int score){
        String grade = "";

        switch (score / 10){
            case 10 :
            case 9 :
                grade = "A";
                break;
            case 8 :
                grade = "B";
                break;
            case 7 :
                grade = "C";
                break;
            case 6 :
            case 5 :
                grade = "D";
                break;
            default:
                grade = "F";
                break;
        }

        return grade;
    }
}
