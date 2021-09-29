package kakao.twenty.intern;

// 키패드 누르기
public class Level1 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        String answer = solution(numbers, hand);
        System.out.println(answer);
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int left = 10;
        int right = 12;

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0) numbers[i] = 11;

            int row = (numbers[i] - 1) / 3;
            int column = (numbers[i] - 1) - row * 3;

            if(column == 0) {
                left = numbers[i];
                answer += "L";
            }else if(column == 2){
                right = numbers[i];
                answer += "R";
            }else{
                int row_left = (left - 1) / 3;
                int column_left = (left - 1) - row_left * 3;

                int sqrt_left = Math.abs(row_left-row) + Math.abs(column_left-column);

                int row_right = (right - 1) / 3;
                int column_right = (right - 1) - row_right * 3;

                int sqrt_right = Math.abs(row_right-row) + Math.abs(column_right-column);

//                System.out.print("numbers:::" + numbers[i] + ":::");
//                System.out.print("right::"+right+":::");
//                System.out.println("left::"+left);
//                if(numbers[i] == 2) {
//                    System.out.println("right:::" + sqrt_right);
//                    System.out.println("left:::" + sqrt_left);
//                }
                if(sqrt_left > sqrt_right){
                    right = numbers[i];
                    answer += "R";
                }else if(sqrt_right > sqrt_left){
                    left = numbers[i];
                    answer += "L";
                }else{

                    if(hand.equals("right")){
                        right = numbers[i];
                        answer += "R";
                    }else{
                        left = numbers[i];
                        answer += "L";
                    }
                }
            }
        }

        return answer;
    }
}
