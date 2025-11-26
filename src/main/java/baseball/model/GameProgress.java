package baseball.model;


public class GameProgress {

    public GameResult process(String computerNumber, UserNumber userNumber) {
        String userNumbers = userNumber.getNumbers();
        int strike = checkStrike(computerNumber, userNumbers);
        int ball = checkBall(computerNumber, userNumbers);

        return GameResult.of(strike, ball);
    }

    private int checkStrike(String computerNumber, String userNumber) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumber.charAt(i) == userNumber.charAt(i)) {
                strike++;
            }
        }

        return strike;
    }

    private int checkBall(String computerNumber, String userNumber) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumber.charAt(i) != userNumber.charAt(i) &&
                    computerNumber.contains(String.valueOf(userNumber.charAt(i)))) {
                ball++;
            }
        }

        return ball;
    }

}
