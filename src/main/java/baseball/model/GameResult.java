package baseball.model;

public class GameResult {

    private final int strike;
    private final int ball;

    private GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static GameResult of(int strike, int ball) {
        return new GameResult(strike, ball);
    }

    public boolean isNoting() {
        return strike == 0 && ball == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
